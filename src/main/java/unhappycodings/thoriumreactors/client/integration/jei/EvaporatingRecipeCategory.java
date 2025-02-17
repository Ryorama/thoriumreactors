package unhappycodings.thoriumreactors.client.integration.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import unhappycodings.thoriumreactors.ThoriumReactors;
import unhappycodings.thoriumreactors.common.recipe.EvaporatingRecipe;
import unhappycodings.thoriumreactors.common.registration.ModBlocks;
import unhappycodings.thoriumreactors.common.util.ScreenUtil;

import java.util.List;

public class EvaporatingRecipeCategory implements IRecipeCategory<EvaporatingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ThoriumReactors.MOD_ID, "evaporating");
    public final static ResourceLocation TEXTURE = new ResourceLocation(ThoriumReactors.MOD_ID, "textures/gui/gui_jei_second.png");

    private final IGuiHelper helper;
    private final IDrawable background;
    private final IDrawable icon;
    private IDrawable tankGroin1;
    private IDrawable progress;

    public EvaporatingRecipeCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 68, 100, 68).addPadding(getGuiTop(), getGuiBottom(), getGuiLeft(), getGuiRight()).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FLUID_EVAPORATION_BLOCK.get()));
        this.helper = helper;
    }

    @Override
    public void draw(@NotNull EvaporatingRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack stack, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
        if (progress == null) {
            this.progress = helper.createAnimatedDrawable(helper.createDrawable(TEXTURE, 202, 234, 32, 22), recipe.getTicks(), IDrawableAnimated.StartDirection.BOTTOM, false);
            this.tankGroin1 = helper.createDrawable(TEXTURE, 242, 168, 4, 63); // 2nd stage
        }
        progress.draw(stack, getGuiLeft() + 35, getGuiTop() + 13);
        tankGroin1.draw(stack, getGuiLeft() + 1, getGuiTop() + 2);

        ScreenUtil.drawCenteredText("Evaporating", stack, getBackground().getWidth() / 2, 6);
        ScreenUtil.drawCenteredText(recipe.getTicks() / 20 + "s", stack, getBackground().getWidth() / 2, 80);
    }

    public int getGuiTop() {
        return 20;
    }

    public int getGuiBottom() {
        return 10;
    }

    public int getGuiLeft() {
        return 10;
    }

    public int getGuiRight() {
        return 12;
    }

    @NotNull
    @Override
    public RecipeType<EvaporatingRecipe> getRecipeType() {
        return JEIModIntegration.EVAPORATING_RECIPE_TYPE;
    }

    @NotNull
    @Override
    public Component getTitle() {
        return Component.translatable("block.thoriumreactors.fluid_evaporation_block");
    }

    @NotNull
    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @NotNull
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EvaporatingRecipe recipe, @NotNull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, getGuiLeft() + 1, getGuiTop() + 1).setFluidRenderer(3000, true, 18, 66)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(new FluidStack(recipe.getFluidIngredient(), (int) (Math.floor((float) recipe.getTicks() / recipe.getOperationAfterTicks()) * recipe.getFluidIngredient().getAmount()))));
        builder.addSlot(RecipeIngredientRole.OUTPUT, getGuiLeft() + 83, getGuiTop() + 22).addItemStack(recipe.getResultItem());
    }
}
