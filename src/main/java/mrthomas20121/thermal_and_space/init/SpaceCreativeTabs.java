package mrthomas20121.thermal_and_space.init;

import mrthomas20121.thermal_and_space.ThermalAndSpace;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SpaceCreativeTabs {

    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalAndSpace.MOD_ID);

    public static RegistryObject<CreativeModeTab> tab_ores = CREATIVE_TABS.register("ores", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(SpaceBlocks.SAND_ORES.get(AstraStone.MARS).get()))
            .title(Component.translatable("creative_tab.thermal_and_space.ores"))
            .displayItems((feature, output) -> {
                for(AstraStone stone: AstraStone.values()) {
                    for(ThermalOre ore: ThermalOre.values()) {
                        output.accept(SpaceBlocks.ORES.get(stone).get(ore).get());
                    }
                    if(stone.isSand()) {
                        output.accept(SpaceBlocks.SAND_ORES.get(stone).get());
                    }
                }
            }).build());
}
