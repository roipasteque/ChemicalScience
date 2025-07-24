package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.ContainerUtils;

public class ContainerOrganicSolarPanel extends GenericContainerBlockEntity<TileOrganicSolarPanel> {

    public static final SubtypeItemUpgrade[] VALID_UPGRADES = new SubtypeItemUpgrade[] { SubtypeItemUpgrade.improvedsolarcell };

    public ContainerOrganicSolarPanel(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(1), new SimpleContainerData(3));
    }

    public ContainerOrganicSolarPanel(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_SOLARPANEL.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        addSlot(new SlotUpgrade(inv, nextIndex(), 25, 42, VALID_UPGRADES));
    }

    @Override
    public boolean stillValid(Player player) {
        return getContainer().stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ContainerUtils.handleShiftClick(slots, player, index);
    }
}