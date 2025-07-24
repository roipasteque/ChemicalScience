package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.pastek.chemicalscience.common.tile.TileCircuitMaker;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.SlotGeneric;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotRestricted;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.ContainerUtils;
import voltaic.prefab.utilities.math.Color;

public class ContainerCircuitMaker extends GenericContainerBlockEntity<TileCircuitMaker> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;
    private final Level level;

    public ContainerCircuitMaker(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(10), new SimpleContainerData(3));
    }

    public ContainerCircuitMaker(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super((MenuType) CSMenuTypes.CONTAINER_CIRCUIT_MAKER.get(), id, playerinv, inventory, inventorydata);
        this.level = playerinv.player.level();
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 38, 31)).setIOColor(new Color(0, 240, 255, 255)));
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 58, 31)).setIOColor(new Color(0, 240, 255, 255)));
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 58, 51)).setIOColor(new Color(0, 240, 255, 255)));
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 104, 51)).setIOColor(new Color(0, 240, 255, 255)));
        this.addSlot((new SlotGeneric(inv, this.nextIndex(), 124, 51)).setIOColor(new Color(0, 240, 255, 255)));
        this.addSlot((new SlotRestricted(inv, this.nextIndex(), 124, 31)).setIOColor(new Color(255, 0, 0, 255)));
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 38, 51));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 14, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 34, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 54, VALID_UPGRADES));
    }

    @Override
    public boolean stillValid(Player player) {
        return getContainer().stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ContainerUtils.handleShiftClick(slots, player, index);
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
