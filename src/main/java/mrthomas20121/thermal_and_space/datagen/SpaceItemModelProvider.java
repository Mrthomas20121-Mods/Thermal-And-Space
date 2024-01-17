package mrthomas20121.thermal_and_space.datagen;

import cofh.lib.init.data.ItemModelProviderCoFH;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpaceItemModelProvider extends ItemModelProviderCoFH {

    public SpaceItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, ThermalAndSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ThermalOre[] ores = ThermalOre.values();
        AstraStone[] stones = AstraStone.values();

        for(AstraStone stone : stones) {

            if(stone.isSand()) {
                // oil shale
                this.blockItem(SpaceBlocks.SAND_ORES.get(stone));
            }

            for(ThermalOre ore: ores) {
                // other ores
                this.blockItem(SpaceBlocks.ORES.get(stone).get(ore));
            }
        }
    }
}
