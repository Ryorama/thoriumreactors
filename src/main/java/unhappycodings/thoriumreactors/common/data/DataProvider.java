package unhappycodings.thoriumreactors.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import unhappycodings.thoriumreactors.ThoriumReactors;

@Mod.EventBusSubscriber(modid = ThoriumReactors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new ModelAndBlockStatesProvider(generator, existingFileHelper));
        generator.addProvider(true, new ItemModelProvider(generator, existingFileHelper));
        generator.addProvider(true, new BlockTagsProvider(generator, existingFileHelper));
        generator.addProvider(true, new ItemTagsProvider(generator, existingFileHelper));
        generator.addProvider(true, new RecipeProvider(generator));
        generator.addProvider(true, new AmericanLanguageProvider(generator, "en_US"));
        generator.addProvider(true, new GermanLanguageProvider(generator, "de_DE"));
        generator.addProvider(true, new SoundProvider(generator, ThoriumReactors.MOD_ID, existingFileHelper));
        generator.addProvider(true, new LootTableProvider(generator));
    }
}
