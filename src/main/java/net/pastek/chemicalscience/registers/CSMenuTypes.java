package net.pastek.chemicalscience.registers;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.*;

public class CSMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChemicalScience.MOD_ID);

    public static final RegistryObject<MenuType<ContainerOrganicSolarPanel>> CONTAINER_SOLARPANEL = register("organicsolarpanel", ContainerOrganicSolarPanel::new);
    public static final RegistryObject<MenuType<ContainerRackM>> CONTAINER_RACK_M = register("rackm", ContainerRackM::new);
    public static final RegistryObject<MenuType<ContainerRackS>> CONTAINER_RACK_S = register("racks", ContainerRackS::new);
    public static final RegistryObject<MenuType<ContainerLabBench>> CONTAINER_LAB_BENCH = register("labbench", ContainerLabBench::new);
    public static final RegistryObject<MenuType<ContainerLabStorage>> CONTAINER_LAB_STORAGE = register("labstorage", ContainerLabStorage::new);
    public static final RegistryObject<MenuType<ContainerCircuitMaker>> CONTAINER_CIRCUIT_MAKER = register("circuitmaker", ContainerCircuitMaker::new);


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String id, MenuType.MenuSupplier<T> supplier) {
        return MENU_TYPES.register(id, () -> new MenuType<>(supplier, FeatureFlags.DEFAULT_FLAGS));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}