package unhappycodings.thoriumreactors.common.block.machine;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import unhappycodings.thoriumreactors.client.config.ClientConfig;
import unhappycodings.thoriumreactors.common.blockentity.machine.MachineConcentratorBlockEntity;
import unhappycodings.thoriumreactors.common.registration.ModBlockEntities;
import unhappycodings.thoriumreactors.common.registration.ModKeyBindings;
import unhappycodings.thoriumreactors.common.util.FormattingUtil;
import unhappycodings.thoriumreactors.common.util.KeyBindingUtil;
import unhappycodings.thoriumreactors.common.util.LootUtil;
import unhappycodings.thoriumreactors.common.util.ParticleUtil;

import java.util.Collections;
import java.util.List;

public class MachineConcentratorBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public MachineConcentratorBlock() {
        super(Properties.of(Material.STONE).strength(5f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 6 : 0;
    }

    @Override
    public void animateTick(BlockState pState, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource randomSource) {
        if (pState.getValue(POWERED)) {
            ParticleUtil.renderSmokeParticles(pos, randomSource, level);
            CompoundTag tag = level.getBlockEntity(pos).saveWithFullMetadata();
            if (tag.getBoolean("InputDump") || tag.getBoolean("OutputDump"))
                ParticleUtil.renderParticles(pos, randomSource, level, ParticleTypes.DOLPHIN);
        }
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public List<ItemStack> getDrops(@NotNull BlockState pState, LootContext.Builder pBuilder) {
        return Collections.singletonList(LootUtil.getLoot(pBuilder.getParameter(LootContextParams.BLOCK_ENTITY), this));
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return LootUtil.getLoot(level.getBlockEntity(pos), this);
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public InteractionResult use(@NotNull BlockState state, @NotNull Level levelIn, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult hitResult) {
        MenuProvider namedContainerProvider = this.getMenuProvider(state, levelIn, pos);
        if (namedContainerProvider != null) {
            if (player instanceof ServerPlayer serverPlayerEntity)
                NetworkHooks.openScreen(serverPlayerEntity, namedContainerProvider, pos);
            return InteractionResult.SUCCESS;
        }

        return super.use(state, levelIn, pos, player, interactionHand, hitResult);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(POWERED, false);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable BlockGetter pLevel, @NotNull List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        CompoundTag tag = pStack.getOrCreateTag().getCompound("BlockEntityTag");
        if (tag.get("RecipeTime") == null) {
            pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.not_placed")).withStyle(FormattingUtil.hex(0xCE1F0A)));
            return;
        }
        if (KeyBindingUtil.isKeyPressed(ModKeyBindings.SHOW_DETAILS) && ClientConfig.showBlockDetails.get()) {
            pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.energy_buffer")).withStyle(FormattingUtil.hex(0x3FD023)).append(Component.literal(FormattingUtil.formatEnergy(Integer.parseInt(String.valueOf(tag.get("Energy"))))).withStyle(ChatFormatting.GRAY)));
            pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.recipe_status")).withStyle(FormattingUtil.hex(0x3BA3D3)).append(Component.translatable(FormattingUtil.getTranslatable("machines.concentrator.name")).append(" " + FormattingUtil.formatPercentNum(tag.getInt("RecipeTime"), tag.getInt("MaxRecipeTime"))).withStyle(ChatFormatting.GRAY)));

            if (!tag.getCompound("FluidIn").isEmpty()) {
                FluidStack fluidIn = FluidStack.loadFluidStackFromNBT(tag.getCompound("FluidIn"));
                pTooltip.add(fluidIn.isEmpty() ? Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.empty")).withStyle(FormattingUtil.hex(0x0ACECE)) : Component.literal(fluidIn.getFluid().getFluidType().getDescription().getString() + ": ").withStyle(FormattingUtil.hex(0x0ACECE)).append(Component.literal(fluidIn.getAmount() + " ").withStyle(ChatFormatting.GRAY)).append(Component.literal("mB").withStyle(FormattingUtil.hex(0x0ACECE))));
            }
            if (!tag.getCompound("FluidOut").isEmpty()) {
                FluidStack fluidOut = FluidStack.loadFluidStackFromNBT(tag.getCompound("FluidOut"));
                pTooltip.add(fluidOut.isEmpty() ? Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.empty")).withStyle(FormattingUtil.hex(0x80ebff)) : Component.literal(fluidOut.getFluid().getFluidType().getDescription().getString() + ": ").withStyle(FormattingUtil.hex(0x80ebff)).append(Component.literal(fluidOut.getAmount() + " ").withStyle(ChatFormatting.GRAY)).append(Component.literal("mB").withStyle(FormattingUtil.hex(0x80ebff))));
            }

            ListTag listtag = tag.getList("Items", 10);
            if (!listtag.isEmpty()) {
                pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.contains_items")).withStyle(ChatFormatting.GRAY));
            }
        } else if (KeyBindingUtil.isKeyPressed(ModKeyBindings.SHOW_DESCRIPTION) && ClientConfig.showBlockDescription.get()) {
            pTooltip.add(Component.translatable(asBlock().getDescriptionId() + "_description").withStyle(ChatFormatting.GRAY));
        } else {
            if (ClientConfig.showBlockDetails.get())
                pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.hold")).withStyle(ChatFormatting.GRAY).append(Component.literal(ModKeyBindings.SHOW_DETAILS.getKey().getDisplayName().getString()).withStyle(FormattingUtil.hex(0x7ED355))).append(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.for_details")).withStyle(ChatFormatting.GRAY)));
            if (ClientConfig.showBlockDescription.get())
                pTooltip.add(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.hold")).withStyle(ChatFormatting.GRAY).append(Component.literal(ModKeyBindings.SHOW_DESCRIPTION.getKey().getDisplayName().getString()).withStyle(FormattingUtil.hex(0x55D38A))).append(Component.translatable(FormattingUtil.getTranslatable("machines.tooltip.for_description")).withStyle(ChatFormatting.GRAY)));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, POWERED);
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModBlockEntities.CONCENTRATOR_BLOCK.get().create(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : (a, b, c, blockEntity) -> ((MachineConcentratorBlockEntity) blockEntity).tick();
    }
}
