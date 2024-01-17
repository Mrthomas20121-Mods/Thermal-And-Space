package mrthomas20121.thermal_and_space.datagen;

import cofh.lib.init.data.LootTableProviderCoFH;
import cofh.thermal.foundation.init.data.tables.TFndBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class SpaceLootGen extends LootTableProviderCoFH {

    public SpaceLootGen(PackOutput output) {

        super(output, List.of(
                new LootTableProvider.SubProviderEntry(SpaceLootProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}

