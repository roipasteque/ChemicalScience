package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileChemicalBench;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.SlotGeneric;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotRestricted;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.math.Color;

public class ContainerChemicalBench extends GenericContainerBlockEntity<TileChemicalBench> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerChemicalBench(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(15), new SimpleContainerData(3));
    }

    public ContainerChemicalBench(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_CHEMICAL_BENCH.get(), id, playerinv, inventory, inventorydata);
    }

    public void addInventorySlots(Container inv, Inventory playerinv) {
        setPlayerInvOffset(35);
        addSlot((new SlotGeneric(inv, nextIndex(), 20, 20)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 40, 20)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 60, 20)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 20, 40)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 40, 40)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 60, 40)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 120, 20)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 140, 20)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 160, 20)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 120, 40)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 140, 40)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 160, 40)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot(new SlotUpgrade(inv, nextIndex(), 80, 70, VALID_UPGRADES));
        addSlot(new SlotUpgrade(inv, nextIndex(), 100, 70, VALID_UPGRADES));
        addSlot(new SlotUpgrade(inv, nextIndex(), 120, 70, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
