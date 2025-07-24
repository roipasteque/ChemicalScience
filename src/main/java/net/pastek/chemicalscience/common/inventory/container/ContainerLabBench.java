package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.tile.TileLabBench;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.ContainerUtils;

public class ContainerLabBench extends GenericContainerBlockEntity<TileLabBench> {

    public ContainerLabBench(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(9), new SimpleContainerData(9));
    }

    public ContainerLabBench(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_LAB_BENCH.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
            for (int chestCol = 0; chestCol < 9; chestCol++) {
                this.addSlot(new Slot(inv, chestCol, 8 + chestCol * 18, 18 + 2*18));
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