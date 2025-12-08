package net.pastek.chemicalscience.client.render.multiblock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

import java.util.HashMap;
import java.util.Map;

public class ObjModelManager {
    public static final ObjModelManager INSTANCE = new ObjModelManager();
    private final Map<ResourceLocation, BakedObjModel> cache = new HashMap<>();

    public BakedObjModel get(ResourceLocation rl) {
        return cache.get(rl);
    }
    public void put(ResourceLocation rl, BakedObjModel model) { cache.put(rl, model); }
    public void clear() { cache.clear(); }

    public void load(ResourceManager rm, ResourceLocation rl) {
        try {
            BakedObjModel model = ObjModelLoader.load(rm, rl);
            if (model != null) put(rl, model);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
