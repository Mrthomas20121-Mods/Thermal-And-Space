package mrthomas20121.thermal_and_space;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(mrthomas20121.thermal_extra.ThermalExtra.MOD_ID)
@Mod.EventBusSubscriber(modid = ThermalExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThermalAndSpace {

	public static final String MOD_ID = "thermal_and_space";
	public static final Logger LOGGER = LogManager.getLogger();

	public ThermalAndSpace() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		//ThermalExtraItems.ITEMS.register(bus);
		//ThermalExtraBlocks.BLOCKS.register(bus);
		//ThermalExtraFluids.FLUIDS.register(bus);
		//ThermalExtraFluids.FLUID_TYPES.register(bus);
		//AdvancedFilter.init();
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if(event.includeServer()) {
			if(ModList.get().isLoaded("tconstruct")) {
				//gen.m_236039_(true, new TinkerRecipeDatagen(gen));
			}
			gen.m_236039_(true, new ExtraRecipeGen(gen));
			ExtraTagGen.BlockTags blockTags = new ExtraTagGen.BlockTags(gen, fileHelper);
			gen.m_236039_(true, blockTags);
			gen.m_236039_(true, new ExtraTagGen.ItemTags(gen, blockTags, fileHelper));
			gen.m_236039_(true, new ExtraTagGen.FluidTags(gen, fileHelper));
		}
		if(event.includeClient()) {
			gen.m_236039_(true, new ExtraModelGen(gen, fileHelper));
			gen.m_236039_(true, new ExtraLangGen(gen));
			gen.m_236039_(true, new ExtraBlockstateGen(gen, fileHelper));
		}
	}
}
