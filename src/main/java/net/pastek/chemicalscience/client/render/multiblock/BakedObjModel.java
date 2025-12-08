package net.pastek.chemicalscience.client.render.multiblock;

import net.minecraft.resources.ResourceLocation;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class BakedObjModel {

    public static class Vertex {
        public final Vector3f pos;
        public final Vector2f uv;
        public final Vector3f normal;
        public Vertex(Vector3f p, Vector2f uv, Vector3f n) {
            this.pos = p; this.uv = uv; this.normal = n;
        }
    }

    public static class Face {
        public final Vertex[] vertices = new Vertex[3];
    }

    public static class Mesh {
        public final List<Face> faces = new ArrayList<>();
        public String materialName;
        public ResourceLocation texture;
    }

    private final List<Mesh> meshes;
    public BakedObjModel(List<Mesh> meshes) { this.meshes = meshes; }
    public List<Mesh> meshes() { return meshes; }
}
