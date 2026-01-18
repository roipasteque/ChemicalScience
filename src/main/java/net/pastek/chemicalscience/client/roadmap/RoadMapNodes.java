package net.pastek.chemicalscience.client.roadmap;

import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.pastek.chemicalscience.ChemicalScience;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoadMapNodes {

    public static final List<ScreenRoadMap.RoadmapNode> NODES = List.of(
            new ScreenRoadMap.RoadmapNode(
                    rl("basic_chemistry"),
                    0, 0,
                    new ItemStack(Items.CRAFTING_TABLE),
                    Component.literal("Basic Chemistry"),
                    Component.literal("The foundation of all science. Start here."),
                    rl("textures/screen/roadmap/nodes/root.png"),
                    1,
                    List.of()
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("electrolysis"),
                    100, 50,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electrolyticseparator)),
                    Component.literal("Electrolysis"),
                    Component.literal("Using electricity to split molecules.\nRequires Basic Chemistry."),
                    rl("textures/screen/roadmap/nodes/electrolysis.png"),
                    32,
                    List.of(rl("basic_chemistry"))
            )
    );

    public static final Map<ResourceLocation, ScreenRoadMap.RoadmapNode> NODE_MAP = NODES.stream()
            .collect(Collectors.toMap(ScreenRoadMap.RoadmapNode::id, Function.identity()));

    private static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, path);
    }
}