package mrthomas20121.thermal_and_space.datagen;

import cofh.lib.data.LootTableProviderCoFH;
import cofh.thermal.foundation.init.TFndItems;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;

import static cofh.thermal.core.ThermalCore.ITEMS;

public class SpaceLoot extends LootTableProviderCoFH {

    public SpaceLoot(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        var regItems = ITEMS;

        for(AstraStone stone: AstraStone.values()) {
            if(stone.isSand()) {
                blockLootTables.put(SpaceBlocks.SAND_ORES.get(stone).get(), this.getSimpleDropTable(SpaceBlocks.SAND_ORES.get(stone).get()));
            }

            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.LEAD).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.LEAD).get(), regItems.get("raw_lead").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.NICKEL).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.NICKEL).get(), regItems.get("raw_nickel").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.TIN).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.TIN).get(), regItems.get("raw_tin").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.SILVER).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.SILVER).get(), regItems.get("raw_silver").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.SULFUR).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.SULFUR).get(), regItems.get("sulfur").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.NITER).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.NITER).get(), regItems.get("niter").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.RUBY).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.RUBY).get(), regItems.get("ruby").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.SAPPHIRE).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.SAPPHIRE).get(), regItems.get("sapphire").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.CINNABAR).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.CINNABAR).get(), regItems.get("cinnabar").asItem()));
            blockLootTables.put(SpaceBlocks.ORES.get(stone).get(ThermalOre.APATITE).get(), this.getSilkTouchOreTable(SpaceBlocks.ORES.get(stone).get(ThermalOre.APATITE).get(), regItems.get("apatite").asItem()));
        }
    }

    @Override
    public @NotNull String getName() {

        return "Thermal And Space: Loot Tables";
    }
}
