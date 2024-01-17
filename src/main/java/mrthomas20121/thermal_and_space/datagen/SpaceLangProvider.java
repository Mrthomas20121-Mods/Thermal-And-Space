package mrthomas20121.thermal_and_space.datagen;

import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class SpaceLangProvider extends LanguageProvider {

    public SpaceLangProvider(PackOutput gen) {
        super(gen, ThermalAndSpace.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ThermalOre[] ores = ThermalOre.values();
        AstraStone[] stones = AstraStone.values();

        for(AstraStone stone : stones) {

            String stoneName = StringUtils.capitalize(stone.name().toLowerCase(Locale.ROOT));

            if(stone.isSand()) {
                // oil shale
                this.addBlock(SpaceBlocks.SAND_ORES.get(stone), stoneName+" Oil Shale");
            }

            for(ThermalOre ore: ores) {
                // other ores
                this.addBlock(SpaceBlocks.ORES.get(stone).get(ore), stoneName+" "+ StringUtils.capitalize(ore.name().toLowerCase(Locale.ROOT)) +" Ore");
            }
        }
    }
}
