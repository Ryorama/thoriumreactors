package unhappycodings.thoriumreactors.common.network.toserver;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;
import unhappycodings.thoriumreactors.common.blockentity.base.MachineContainerBlockEntity;
import unhappycodings.thoriumreactors.common.network.base.IPacket;

public class MachinePowerablePacket implements IPacket {
    private final BlockPos pos;
    private final boolean powerable;

    public MachinePowerablePacket(BlockPos pos, boolean powerable) {
        this.pos = pos;
        this.powerable = powerable;
    }

    public static MachinePowerablePacket decode(FriendlyByteBuf buffer) {
        return new MachinePowerablePacket(buffer.readBlockPos(), buffer.readBoolean());
    }

    @SuppressWarnings("ConstantConditions")
    public void handle(NetworkEvent.Context context) {
        ServerPlayer player = context.getSender();
        BlockEntity machine = player.getCommandSenderWorld().getBlockEntity(pos);
        if (!(machine instanceof MachineContainerBlockEntity blockEntity)) return;
        blockEntity.setPowerable(powerable);

    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(pos);
        buffer.writeBoolean(powerable);
    }
}
