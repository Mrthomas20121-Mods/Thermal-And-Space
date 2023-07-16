package mrthomas20121.thermal_and_space;

import mrthomas20121.thermal_and_space.datagen.SpaceBlockStateProvider;
import mrthomas20121.thermal_and_space.datagen.SpaceItemModelProvider;
import mrthomas20121.thermal_and_space.datagen.SpaceLangProvider;
import mrthomas20121.thermal_and_space.datagen.SpaceTagsProvider;
import mrthomas20121.thermal_and_space.init.ThermalSpaceBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ThermalAndSpace.MOD_ID)
@Mod.EventBusSubscriber(modid = ThermalAndSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalAndSpace {

	public static final String MOD_ID = "thermal_and_space";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalAndSpace() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ThermalSpaceBlocks.BLOCKS.register(bus);
		ThermalSpaceBlocks.ITEMS.register(bus);
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		// server providers
		SpaceTagsProvider.Block block = new SpaceTagsProvider.Block(gen, fileHelper);
		gen.addProvider(event.includeServer(), block);
		gen.addProvider(event.includeServer(), new SpaceTagsProvider.Item(gen, block, fileHelper));

		// client providers
		gen.addProvider(event.includeClient(), new SpaceLangProvider(gen));
		gen.addProvider(event.includeClient(), new SpaceBlockStateProvider(gen, fileHelper));
		gen.addProvider(event.includeClient(), new SpaceItemModelProvider(gen, fileHelper));
	}
}
