package mrthomas20121.thermal_and_space;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import mrthomas20121.thermal_and_space.datagen.*;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(ThermalAndSpace.MOD_ID)
@Mod.EventBusSubscriber(modid = ThermalAndSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalAndSpace {

	public static final String MOD_ID = "thermal_and_space";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalAndSpace() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		SpaceBlocks.BLOCKS.register(bus);
		SpaceBlocks.ITEMS.register(bus);
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		// server providers
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		PackOutput packOutput = gen.getPackOutput();
		SpaceTagsProvider.Block block = new SpaceTagsProvider.Block(packOutput, lookupProvider, fileHelper);
		gen.addProvider(event.includeServer(), block);
		gen.addProvider(event.includeServer(), new SpaceTagsProvider.Item(packOutput, lookupProvider, block, fileHelper));

		// client providers
		gen.addProvider(event.includeClient(), new SpaceLangProvider(packOutput));
		gen.addProvider(event.includeClient(), new SpaceBlockStateProvider(packOutput, fileHelper));
		gen.addProvider(event.includeClient(), new SpaceItemModelProvider(packOutput, fileHelper));

		gen.addProvider(event.includeServer(), new SpaceRegistrySets(packOutput, lookupProvider));
		gen.addProvider(event.includeServer(), new SpaceLootGen(gen.getPackOutput()));
	}
}
