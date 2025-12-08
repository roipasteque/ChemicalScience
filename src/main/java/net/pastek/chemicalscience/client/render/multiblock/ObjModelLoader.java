package net.pastek.chemicalscience.client.render.multiblock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ObjModelLoader {

    public static BakedObjModel load(ResourceManager rm, ResourceLocation objLoc) throws Exception {

        var res = rm.getResource(objLoc)
                .orElseThrow(() -> new IllegalArgumentException("Missing " + objLoc));

        try (InputStream is = res.open();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            List<Vector3f> pos = new ArrayList<>();
            List<Vector2f> uv = new ArrayList<>();
            List<Vector3f> norm = new ArrayList<>();

            Map<String, ResourceLocation> materialToTex = new HashMap<>();

            class TempMesh {
                final List<BakedObjModel.Face> faces = new ArrayList<>();
            }

            Map<String, TempMesh> tempMeshes = new LinkedHashMap<>();
            String currentMat = "default";
            tempMeshes.put(currentMat, new TempMesh());

            String basePath = objLoc.getPath();
            int lastSlash = basePath.lastIndexOf('/');
            String baseDir = lastSlash >= 0 ? basePath.substring(0, lastSlash + 1) : "";

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                line = line.trim();

                if (line.startsWith("v ")) {
                    String[] s = line.split("\\s+");
                    pos.add(new Vector3f(
                            Float.parseFloat(s[1]),
                            Float.parseFloat(s[2]),
                            Float.parseFloat(s[3])
                    ));
                }
                else if (line.startsWith("vt ")) {
                    String[] s = line.split("\\s+");
                    uv.add(new Vector2f(
                            Float.parseFloat(s[1]),
                            1f - Float.parseFloat(s[2])
                    ));
                }
                else if (line.startsWith("vn ")) {
                    String[] s = line.split("\\s+");
                    norm.add(new Vector3f(
                            Float.parseFloat(s[1]),
                            Float.parseFloat(s[2]),
                            Float.parseFloat(s[3])
                    ));
                }

                else if (line.startsWith("mtllib ")) {
                    ResourceLocation mtlLoc = ResourceLocation.fromNamespaceAndPath(
                            objLoc.getNamespace(),
                            baseDir + line.substring(7).trim()
                    );
                    parseMtl(rm, mtlLoc, materialToTex);
                }
                else if (line.startsWith("usemtl ")) {
                    currentMat = line.substring(7).trim();
                    tempMeshes.putIfAbsent(currentMat, new TempMesh());
                }

                else if (line.startsWith("f ")) {
                    String[] parts = line.substring(2).trim().split("\\s+");
                    int n = parts.length;
                    if (n < 3) continue;

                    int[] vi = new int[n];
                    int[] ti = new int[n];
                    int[] ni = new int[n];

                    for (int i = 0; i < n; i++) {
                        String[] triple = parts[i].split("/");
                        vi[i] = parseIndex(triple[0], pos.size());

                        ti[i] = (triple.length > 1 && !triple[1].isEmpty())
                                ? parseIndex(triple[1], uv.size()) : -1;

                        ni[i] = (triple.length > 2 && !triple[2].isEmpty())
                                ? parseIndex(triple[2], norm.size()) : -1;
                    }

                    TempMesh tm = tempMeshes.get(currentMat);

                    for (int i = 1; i < n - 1; i++) {
                        BakedObjModel.Vertex v0 = makeVertex(pos, uv, norm, vi[0], ti[0], ni[0]);
                        BakedObjModel.Vertex v1 = makeVertex(pos, uv, norm, vi[i], ti[i], ni[i]);
                        BakedObjModel.Vertex v2 = makeVertex(pos, uv, norm, vi[i + 1], ti[i + 1], ni[i + 1]);

                        BakedObjModel.Face face = new BakedObjModel.Face();

                        face.vertices[0] = v0;
                        face.vertices[1] = v1;
                        face.vertices[2] = v2;

                        tm.faces.add(face);
                    }
                }
            }

            List<BakedObjModel.Mesh> out = new ArrayList<>();

            for (Map.Entry<String, TempMesh> entry : tempMeshes.entrySet()) {
                String mat = entry.getKey();
                TempMesh tm = entry.getValue();

                if (tm.faces.isEmpty()) continue;

                ResourceLocation tex = materialToTex.getOrDefault(mat, null);
                BakedObjModel.Mesh mesh = new BakedObjModel.Mesh();

                mesh.faces.addAll(tm.faces);
                mesh.materialName = mat;
                mesh.texture = tex;

                out.add(mesh);
            }

            return new BakedObjModel(out);
        }
    }

    private static BakedObjModel.Vertex makeVertex(List<Vector3f> pos,
                                                   List<Vector2f> uv,
                                                   List<Vector3f> norm,
                                                   int vi, int ti, int ni) {

        Vector3f p = (vi >= 0 && vi < pos.size())
                ? new Vector3f(pos.get(vi))
                : new Vector3f();

        Vector2f t = (ti >= 0 && ti < uv.size())
                ? new Vector2f(uv.get(ti))
                : new Vector2f();

        Vector3f n = (ni >= 0 && ni < norm.size())
                ? new Vector3f(norm.get(ni))
                : new Vector3f(0, 1, 0);

        return new BakedObjModel.Vertex(p, t, n);
    }

    private static int parseIndex(String token, int size) {
        int idx = Integer.parseInt(token);
        return idx < 0 ? size + idx : idx - 1;
    }

    private static void parseMtl(ResourceManager rm,
                                 ResourceLocation mtlLoc,
                                 Map<String, ResourceLocation> matMap) {

        Optional<Resource> res = rm.getResource(mtlLoc);
        if (res.isEmpty()) return;

        try (InputStream is = res.get().open();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String current = null;
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                if (line.startsWith("newmtl ")) {
                    current = line.substring(7).trim();
                }
                else if (line.startsWith("map_Kd ") && current != null) {
                    String tex = line.substring(7).trim();
                    ResourceLocation rl;
                    if (tex.contains(":")) {
                        rl = ResourceLocation.parse(tex);
                    } else {
                        rl = ResourceLocation.fromNamespaceAndPath(mtlLoc.getNamespace(), tex);
                    }
                    matMap.put(current, rl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}