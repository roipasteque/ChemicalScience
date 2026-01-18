package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.prefab.inventory.container.GenericContainer;

public class ContainerRoadMap extends GenericContainer<Container> {

    public ContainerRoadMap(int id, Inventory playerinv) {
        super(CSMenuTypes.CONTAINER_ROADMAP.get(), id, playerinv, EMPTY);
    }

    @Override
    public void validateContainer(Container inventory) {

    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {

    }

    @Override
    public void addPlayerInventory(Inventory playerinv) {

    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}