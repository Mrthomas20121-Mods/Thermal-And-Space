package mrthomas20121.thermal_and_space.datagen;

import cofh.lib.data.ItemModelProviderCoFH;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import mrthomas20121.thermal_and_space.init.ThermalSpaceBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SpaceItemModelProvider extends ItemModelProviderCoFH {

    public SpaceItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ThermalAndSpace.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ThermalOre[] ores = ThermalOre.values();
        AstraStone[] stones = AstraStone.values();

        for(AstraStone stone : stones) {

            if(stone.isSand()) {
                // oil shale
                this.blockItem(ThermalSpaceBlocks.SAND_ORES.get(stone));
            }

            for(ThermalOre ore: ores) {
                // other ores
                this.blockItem(ThermalSpaceBlocks.ORES.get(stone).get(ore));
            }
        }
    }
}
