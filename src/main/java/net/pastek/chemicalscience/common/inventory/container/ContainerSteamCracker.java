package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileHDSUnit;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.SlotGeneric;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotGas;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.math.Color;

public class ContainerSteamCracker extends GenericContainerBlockEntity<TileHDSUnit> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerSteamCracker(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(10), new SimpleContainerData(3));
    }

    public ContainerSteamCracker(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super((MenuType) CSMenuTypes.CONTAINER_HDS_UNIT.get(), id, playerinv, inventory, inventorydata);
    }

    public ContainerSteamCracker(MenuType<?> type, int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(type, id, playerinv, inventory, inventorydata);
    }

    public void addInventorySlots(Container inv, Inventory playerinv) {
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 58, 31)).setIOColor(new Color(0, 240, 0, 0)));
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 18, 51));
        this.addSlot(new SlotGas(inv, this.nextIndex(), 38, 51));
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 98, 51));
        this.addSlot(new SlotGas(inv, this.nextIndex(), 118, 51));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 14, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 34, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 54, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
