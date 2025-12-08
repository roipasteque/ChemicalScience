package net.pastek.chemicalscience.client.render.multiblock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.pastek.chemicalscience.ChemicalScience;

public class ObjModelReloadListener extends SimplePreparableReloadListener<Void> {
    public static final ResourceLocation MIXER = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "models/multiblock/mixer.obj");

    @Override
    protected Void prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        return null;
    }

    @Override
    protected void apply(Void nothing, ResourceManager resourceManager, ProfilerFiller profiler) {
        ObjModelManager.INSTANCE.clear();
        ObjModelManager.INSTANCE.load(resourceManager, MIXER);
    }
}
