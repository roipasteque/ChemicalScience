package net.pastek.chemicalscience.client.roadmap;

import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.item.subtype.SubtypeDust;
import electrodynamics.common.item.subtype.SubtypeIngot;
import electrodynamics.common.item.subtype.SubtypePlate;
import electrodynamics.registers.ElectrodynamicsBlocks;
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

    public static int colorWireiron = 0xFFBEBEBE;
    public static int colorWiretin = 0xFFC0BBB6;
    public static int colorWirecopper = 0xFFD46B46;
    public static int colorWiresilver = 0xFFDCDCDC;
    public static int colorWiregold = 0xFFFBE554;
    public static int colorWiresuperconductive = 0xFFA2A293;

    public static final List<ScreenRoadMap.RoadmapNode> NODES = List.of(
            new ScreenRoadMap.RoadmapNode(
                    rl("electrodynamics"),
                    -128, 0,
                    new ItemStack(Items.CRAFTING_TABLE),
                    Component.translatable("roadmap.chemicalscience.node.electrodynamics.title"),
                    Component.translatable("roadmap.chemicalscience.node.electrodynamics.desc"),
                    rl("textures/screen/roadmap/nodes/root.png"),
                    1,
                    List.of(),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("ingotsteel"),
                    -64, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_INGOT.getValue(SubtypeIngot.steel)),
                    Component.translatable("roadmap.chemicalscience.node.ingotsteel.title"),
                    Component.translatable("roadmap.chemicalscience.node.ingotsteel.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("platesteel"),
                    0, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_PLATE.getValue(SubtypePlate.steel)),
                    Component.translatable("roadmap.chemicalscience.node.platesteel.title"),
                    Component.translatable("roadmap.chemicalscience.node.platesteel.desc"),
                    null,
                    1,
                    List.of(rl("ingotsteel")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("wirecopper"),
                    -64, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_WIRE.getValue(SubtypeWire.copper)),
                    Component.translatable("roadmap.chemicalscience.node.wirecopper.title"),
                    Component.translatable("roadmap.chemicalscience.node.wirecopper.desc"),
                    null,
                    1,
                    List.of(rl("electrodynamics")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("coil"),
                    0, 0,
                    new ItemStack(ElectrodynamicsItems.ITEM_COIL),
                    Component.translatable("roadmap.chemicalscience.node.coil.title"),
                    Component.translatable("roadmap.chemicalscience.node.coil.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("insulation"),
                    -64, 64,
                    new ItemStack(ElectrodynamicsItems.ITEM_INSULATION),
                    Component.translatable("roadmap.chemicalscience.node.insulation.title"),
                    Component.translatable("roadmap.chemicalscience.node.insulation.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("insulatedwire"),
                    0, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_WIRE.getValue(SubtypeWire.insulatedcopperblack)),
                    Component.translatable("roadmap.chemicalscience.node.insulatedwire.title"),
                    Component.translatable("roadmap.chemicalscience.node.insulatedwire.desc"),
                    null,
                    1,
                    List.of(rl("insulation")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("motor"),
                    64, 0,
                    new ItemStack(ElectrodynamicsItems.ITEM_MOTOR),
                    Component.translatable("roadmap.chemicalscience.node.motor.title"),
                    Component.translatable("roadmap.chemicalscience.node.motor.desc"),
                    null,
                    1,
                    List.of(rl("coil"), rl("platesteel"), rl("insulatedwire")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("coalgenerator"),
                    128, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.coalgenerator)),
                    Component.translatable("roadmap.chemicalscience.node.coalgenerator.title"),
                    Component.translatable("roadmap.chemicalscience.node.coalgenerator.desc"),
                    null,
                    1,
                    List.of(rl("motor")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("tiningot"),
                    128, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_INGOT.getValue(SubtypeIngot.tin)),
                    Component.translatable("roadmap.chemicalscience.node.tiningot.title"),
                    Component.translatable("roadmap.chemicalscience.node.tiningot.desc"),
                    null,
                    1,
                    List.of(rl("coalgenerator")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("battery"),
                    196, 64,
                    new ItemStack(ElectrodynamicsItems.ITEM_BATTERY),
                    Component.translatable("roadmap.chemicalscience.node.battery.title"),
                    Component.translatable("roadmap.chemicalscience.node.battery.desc"),
                    null,
                    1,
                    List.of(rl("tiningot")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("batterybox"),
                    196, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.batterybox)),
                    Component.translatable("roadmap.chemicalscience.node.batterybox.title"),
                    Component.translatable("roadmap.chemicalscience.node.batterybox.desc"),
                    null,
                    1,
                    List.of(rl("battery"), rl("coalgenerator")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grinder"),
                    256, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrinder)),
                    Component.translatable("roadmap.chemicalscience.node.grinder.title"),
                    Component.translatable("roadmap.chemicalscience.node.grinder.desc"),
                    null,
                    1,
                    List.of(rl("batterybox")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grinderdouble"),
                    256, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrinderdouble)),
                    Component.translatable("roadmap.chemicalscience.node.grinderdouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.grinderdouble.desc"),
                    null,
                    1,
                    List.of(rl("grinder")),
                    colorWiresilver,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grindertriple"),
                    256, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrindertriple)),
                    Component.translatable("roadmap.chemicalscience.node.grindertriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.grindertriple.desc"),
                    null,
                    1,
                    List.of(rl("grinderdouble")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("dustcopper"),
                    256, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.copper)),
                    Component.translatable("roadmap.chemicalscience.node.dustcopper.title"),
                    Component.translatable("roadmap.chemicalscience.node.dustcopper.desc"),
                    null,
                    1,
                    List.of(rl("grinder")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110
            )
    );

    public static final Map<ResourceLocation, ScreenRoadMap.RoadmapNode> NODE_MAP = NODES.stream()
            .collect(Collectors.toMap(ScreenRoadMap.RoadmapNode::id, Function.identity()));

    private static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, path);
    }
}