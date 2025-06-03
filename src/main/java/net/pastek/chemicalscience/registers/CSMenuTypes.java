package net.pastek.chemicalscience.registers;


import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.*;

public class CSMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, ChemicalScience.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<ContainerOrganicSolarPanel>> CONTAINER_SOLARPANEL = register("organicsolarpanel", ContainerOrganicSolarPanel::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerFuelCell>> CONTAINER_FUELCELL = register("fuelcell", ContainerFuelCell::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRackM>> CONTAINER_RACK_M = register("rackm", ContainerRackM::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRackS>> CONTAINER_RACK_S = register("racks", ContainerRackS::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerLabBench>> CONTAINER_LAB_BENCH = register("labbench", ContainerLabBench::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerLabStorage>> CONTAINER_LAB_STORAGE = register("labstorage", ContainerLabStorage::new);


    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>,MenuType<T>> register(String id, MenuType.MenuSupplier<T> supplier) {
        return MENU_TYPES.register(id, () -> new MenuType<>(supplier, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}