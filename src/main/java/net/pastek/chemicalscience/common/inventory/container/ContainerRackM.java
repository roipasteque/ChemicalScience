package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.ContainerUtils;

public class ContainerRackM extends GenericContainerBlockEntity<TileRackM> {

    public ContainerRackM(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(27), new SimpleContainerData(27));
    }

    public ContainerRackM(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_RACK_M.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        for (int chestRow = 0; chestRow < 3; chestRow++) {
            for (int chestCol = 0; chestCol < 9; chestCol++) {
                this.addSlot(new Slot(inv, chestCol + chestRow * 9, 8 + chestCol * 18, 18 + chestRow * 18));
            }
        }
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