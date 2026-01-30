package net.pastek.chemicalscience.common.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;

public record PacketTransparencyTogglePayload(BlockPos pos) implements CustomPacketPayload {
    public static final Type<PacketTransparencyTogglePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "transparency_toggle"));

    public static final StreamCodec<ByteBuf, PacketTransparencyTogglePayload> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, PacketTransparencyTogglePayload::pos,
            PacketTransparencyTogglePayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final PacketTransparencyTogglePayload data, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level level = player.level();
            BlockPos pos = data.pos();

            if (level.isLoaded(pos)) {
                BlockState state = level.getBlockState(pos);
                if (state.hasProperty(TileOrganicSolarPanel.TRANSPARENCY)) {
                    TileOrganicSolarPanel.TransparencyLevel current = state.getValue(TileOrganicSolarPanel.TRANSPARENCY);
                    TileOrganicSolarPanel.TransparencyLevel next = (current == TileOrganicSolarPanel.TransparencyLevel.OPAQUE)
                            ? TileOrganicSolarPanel.TransparencyLevel.TRANSPARENT 
                            : TileOrganicSolarPanel.TransparencyLevel.OPAQUE;
                    
                    level.setBlock(pos, state.setValue(TileOrganicSolarPanel.TRANSPARENCY, next), 3);
                }
            }
        });
    }
}