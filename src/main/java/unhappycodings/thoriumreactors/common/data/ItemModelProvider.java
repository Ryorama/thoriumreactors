package unhappycodings.thoriumreactors.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import unhappycodings.thoriumreactors.ThoriumReactors;
import unhappycodings.thoriumreactors.common.registration.ModBlocks;
import unhappycodings.thoriumreactors.common.registration.ModItems;
import unhappycodings.thoriumreactors.common.util.ItemUtil;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ThoriumReactors.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GRAPHITE_CRYSTAL.get());
        simpleItem(ModItems.GRAPHITE_INGOT.get());
        simpleItem(ModItems.GRAPHITE_TUBE.get());
        simpleItem(ModItems.GRAPHITE_NUGGET.get());

        simpleItem(ModItems.BLASTED_IRON_INGOT.get());
        simpleItem(ModItems.BLASTED_IRON_NUGGET.get());

        simpleItem(ModItems.STEEL_INGOT.get());
        simpleItem(ModItems.STEEL_NUGGET.get());

        simpleItem(ModItems.MOLYBDENUM_INGOT.get());
        simpleItem(ModItems.MOLYBDENUM_NUGGET.get());

        simpleItem(ModItems.MANGANESE_INGOT.get());
        simpleItem(ModItems.MANGANESE_NUGGET.get());

        simpleItem(ModItems.NICKEL_INGOT.get());
        simpleItem(ModItems.NICKEL_NUGGET.get());

        simpleItem(ModItems.ALUMINUM_INGOT.get());
        simpleItem(ModItems.ALUMINUM_NUGGET.get());

        simpleItem(ModItems.CHROMIUM_INGOT.get());
        simpleItem(ModItems.CHROMIUM_NUGGET.get());

        simpleItem(ModItems.NIOB_INGOT.get());
        simpleItem(ModItems.NIOB_NUGGET.get());

        simpleItem(ModItems.TITANIUM_INGOT.get());
        simpleItem(ModItems.TITANIUM_NUGGET.get());

        simpleItem(ModItems.URANIUM_INGOT.get());
        simpleItem(ModItems.URANIUM_NUGGET.get());

        simpleItem(ModItems.FLUORITE_INGOT.get());
        simpleItem(ModItems.FLUORITE_NUGGET.get());

        simpleItem(ModItems.COBALT_INGOT.get());
        simpleItem(ModItems.COBALT_NUGGET.get());

        simpleItem(ModItems.SODIUM.get());
        simpleItem(ModItems.POTASSIUM.get());
        simpleItem(ModItems.URAN_THREE_CHLORIDE.get());
        simpleItem(ModItems.STEEL_INGOT.get());
        simpleItem(ModItems.RAW_URANIUM.get());
        simpleItem(ModItems.ENRICHED_URANIUM.get());
        simpleItem(ModItems.DEPLETED_URANIUM.get());
        simpleItem(ModItems.REDSTONE_PROCESSOR.get());
        simpleItem(ModItems.THORIUM.get());
        simpleItem(ModItems.YELLOW_CAKE.get());
        simpleItem(ModItems.FLUORITE.get());
        simpleItem(ModItems.CONFIGURATOR.get());

        simpleItem(ModItems.MOLTEN_SALT_BUCKET.get());
        simpleItem(ModItems.DEPLETED_MOLTEN_SALT_BUCKET.get(), ModItems.MOLTEN_SALT_BUCKET.get());
        simpleItem(ModItems.HEATED_MOLTEN_SALT_BUCKET.get());
        simpleItem(ModItems.HYDROFLUORITE_BUCKET.get());
        simpleItem(ModItems.URANIUM_HEXAFLUORITE_BUCKET.get());
        simpleItem(ModItems.ENRICHED_URANIUM_HEXAFLUORITE_BUCKET.get());
        simpleItem(ModItems.STEAM_BUCKET.get());

        simpleItem(ModItems.MODULE_EMPTY.get());
        simpleItem(ModItems.MODULE_IO.get());
        simpleItem(ModItems.MODULE_ENERGY.get());
        simpleItem(ModItems.MODULE_STORAGE.get());
        simpleItem(ModItems.MODULE_TANK.get());
        simpleItem(ModItems.MODULE_SENSOR.get());
        simpleItem(ModItems.MODULE_PROCESSING.get());

        withExistingParent(ItemUtil.getRegString(ModBlocks.FACTORY_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/factory_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INVERTED_FACTORY_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/inverted_factory_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_FACTORY_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_factory_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INVERTED_FACTORY_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_inverted_factory_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GRATE_FLOOR_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/grate_floor_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK_BIG_TILE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block_big_tile"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK_PAVING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block_paving"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK_BRICK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block_brick"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK_SMOOTH.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block_smooth"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.INDUSTRAL_BLOCK_FLOOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/industrial_block_floor"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FRAMELESS_INDUSTRAL_BLOCK_FLOOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/frameless_industrial_block_floor"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK_BIG_TILE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block_big_tile"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK_PAVING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block_paving"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK_BRICK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block_brick"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK_SMOOTH.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block_smooth"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLACK_INDUSTRAL_BLOCK_FLOOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/black_industrial_block_floor"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FRAMELESS_BLACK_INDUSTRAL_BLOCK_FLOOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/frameless_black_industrial_block_floor"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.WHITE_INDUSTRAL_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/white_industrial_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WHITE_INDUSTRAL_BLOCK_BIG_TILE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/white_industrial_block_big_tile"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WHITE_INDUSTRAL_BLOCK_PAVING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/white_industrial_block_paving"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WHITE_INDUSTRAL_BLOCK_BRICK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/white_industrial_block_brick"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WHITE_INDUSTRAL_BLOCK_SMOOTH.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/white_industrial_block_smooth"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_BLACK_YELLOW_LEFT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_black_yellow_left"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_BLACK_YELLOW_RIGHT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_black_yellow_right"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_WHITE_ORANGE_LEFT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_white_orange_left"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_WHITE_ORANGE_RIGHT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_white_orange_right"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_WHITE_BLACK_LEFT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_white_black_left"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.WARNING_BLOCK_LINED_WHITE_BLACK_RIGHT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/warning_block_lined_white_black_right"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.SIMPLE_ENERGY_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GENERIC_ENERGY_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.PROGRESSIVE_ENERGY_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CREATIVE_ENERGY_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.SIMPLE_FLUID_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GENERIC_FLUID_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.PROGRESSIVE_FLUID_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CREATIVE_FLUID_TANK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.WATER_SOURCE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/builtinentitymodel"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.THORIUM_CRAFTING_TABLE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thorium_crafting_table"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.BLASTED_STONE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/blasted_stone"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.THORIUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thorium_block"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.BLASTED_IRON_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/blasted_iron_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.STEEL_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/steel_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.MANGANESE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/manganese_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CHROMIUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/chromium_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.MOLYBDENUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/molybdenum_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.NICKEL_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/nickel_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TITANIUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/titanium_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.ALUMINUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/aluminum_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.NIOB_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/niob_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.COBALT_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/cobalt_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.URANIUM_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/uranium_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GRAPHITE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/graphite_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FLUORITE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/fluorite_block"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.MANGANESE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/manganese_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_MANGANESE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_manganese_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CHROMITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/chromite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_CHROMITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_chromite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.MOLYBDENUM_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/molybdenum_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_MOLYBDENUM_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_molybdenum_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.NICKEL_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/nickel_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_NICKEL_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_nickel_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TITANIC_IRON_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/titanic_iron_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_TITANIC_IRON_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_titanic_iron_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BAUXITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/bauxite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_BAUXITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_bauxite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.PYROCHLOR_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/pyrochlor_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_PYROCHLOR_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_pyrochlor_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.URANIUM_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/uranium_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_URANIUM_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_uranium_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GRAPHITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/graphite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_GRAPHITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_graphite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FLUORITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/fluorite_ore"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DEEPSLATE_FLUORITE_ORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/deepslate_fluorite_ore"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.THERMAL_CONDUCTOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thermal_conductor"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.THERMAL_CONTROLLER.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thermal_controller"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.THERMAL_VALVE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thermal_valve"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.THERMAL_HEAT_SINK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/thermal_heat_sink"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_GLASS.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_glass"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_CASING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_casing"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_VALVE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_valve"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_CORE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_core_off"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_CONTROLLER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_controller"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_ROD_CONTROLLER.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_rod_controller"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.REACTOR_GRAPHITE_MODERATOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/reactor_graphite_moderator"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.ELECTROMAGNETIC_COIL.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/electromagnetic_coil"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_CASING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_casing"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_CONTROLLER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_controller"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_VALVE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_valve"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_VENT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_vent"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_ROTATION_MOUNT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_rotation_mount"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_ROTOR.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_rotor_0"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_POWER_PORT.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_power_port"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.TURBINE_GLASS.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/turbine_glass"));
        withExistingParent(ItemUtil.getRegString(ModItems.TURBINE_BLADE.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "generation/turbine_blade_item"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.ELECTROLYTIC_SALT_SEPARATOR_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/electrolytic_salt_separator"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FLUID_EVAPORATION_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/fluid_evaporation_block_off"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.GENERATOR_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/generator_block_off"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.SALT_MELTER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/salt_melter_block_off"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CONCENTRATOR_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/concentrator_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.DECOMPOSER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/decomposer_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.URANIUM_OXIDIZER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/uranium_oxidizer_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FLUID_ENRICHER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/fluid_enricher_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.FLUID_CENTRIFUGE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/fluid_centrifuge_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.CRYSTALLIZER_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/crystallizer_block"));
        withExistingParent(ItemUtil.getRegString(ModBlocks.BLAST_FURNACE_BLOCK.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/blast_furnace_block_off"));

        withExistingParent(ItemUtil.getRegString(ModBlocks.MACHINE_CASING.get()), new ResourceLocation(ThoriumReactors.MOD_ID, "block/machine_casing"));

    }

    private void simpleItem(Item item) {
        withExistingParent(ItemUtil.getRegString(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" + ItemUtil.getRegName(item).getPath()));
    }

    private void simpleItem(Item item, Item textureItem) {
        withExistingParent(ItemUtil.getRegString(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" + ItemUtil.getRegName(textureItem).getPath()));
    }

    private void simpleItem(Item item, ResourceLocation texture) {
        withExistingParent(ItemUtil.getRegString(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" + texture));
    }

}
