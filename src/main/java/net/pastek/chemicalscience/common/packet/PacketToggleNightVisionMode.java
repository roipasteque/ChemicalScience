package net.pastek.chemicalscience.common.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;

public record PacketToggleNightVisionMode() implements CustomPacketPayload {

    public static final Type<PacketToggleNightVisionMode> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "toggle_nv_mode"));

    public static final StreamCodec<ByteBuf, PacketToggleNightVisionMode> STREAM_CODEC = StreamCodec.unit(new PacketToggleNightVisionMode());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(PacketToggleNightVisionMode payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

            if (helmet.getItem() instanceof ItemOrganicNightVisionGoggles goggles) {
                goggles.cycleMode(helmet, player);
            }
        });
    }
}