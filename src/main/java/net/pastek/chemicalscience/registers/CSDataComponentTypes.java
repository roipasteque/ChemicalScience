package net.pastek.chemicalscience.registers;

import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.prefab.utilities.NBTUtils;

public class CSDataComponentTypes {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, ChemicalScience.MOD_ID);


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> ON = DATA_COMPONENT_TYPES.register(NBTUtils.ON, () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding().build());


    public static void register(IEventBus bus) {
        DATA_COMPONENT_TYPES.register(bus);
    }
}