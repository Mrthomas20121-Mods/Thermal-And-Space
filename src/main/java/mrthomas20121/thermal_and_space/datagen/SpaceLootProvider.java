package mrthomas20121.thermal_and_space.datagen;

import cofh.lib.common.block.OreBlockCoFH;
import cofh.lib.init.data.loot.BlockLootSubProviderCoFH;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import static cofh.thermal.core.ThermalCore.ITEMS;

public class SpaceLootProvider extends BlockLootSubProviderCoFH {

    @Override
    protected void generate() {
        var regItems = ITEMS;

        for(AstraStone stone: AstraStone.values()) {
            if(stone.isSand()) {
                getSimpleDropTable(SpaceBlocks.SAND_ORES.get(stone).get());
            }

            OreBlockCoFH apatite = SpaceBlocks.ORES.get(stone).get(ThermalOre.APATITE).get();
            add(apatite, createSilkTouchDispatchTable(apatite, applyExplosionDecay(apatite, LootItem.lootTableItem(regItems.get("apatite"))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

            OreBlockCoFH cinnabar = SpaceBlocks.ORES.get(stone).get(ThermalOre.CINNABAR).get();
            add(cinnabar, createSilkTouchDispatchTable(cinnabar, applyExplosionDecay(cinnabar, LootItem.lootTableItem(regItems.get("cinnabar"))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

            OreBlockCoFH niter = SpaceBlocks.ORES.get(stone).get(ThermalOre.NITER).get();
            add(niter, createSilkTouchDispatchTable(niter, applyExplosionDecay(niter, LootItem.lootTableItem(regItems.get("niter"))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

            OreBlockCoFH sulfur = SpaceBlocks.ORES.get(stone).get(ThermalOre.SULFUR).get();
            add(sulfur, createSilkTouchDispatchTable(sulfur, applyExplosionDecay(sulfur, LootItem.lootTableItem(regItems.get("sulfur"))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

            OreBlockCoFH lead = SpaceBlocks.ORES.get(stone).get(ThermalOre.LEAD).get();
            OreBlockCoFH nickel = SpaceBlocks.ORES.get(stone).get(ThermalOre.NICKEL).get();
            OreBlockCoFH silver = SpaceBlocks.ORES.get(stone).get(ThermalOre.SILVER).get();
            OreBlockCoFH tin = SpaceBlocks.ORES.get(stone).get(ThermalOre.TIN).get();
            add(lead, getSilkTouchOreTable(lead, regItems.get("raw_lead")));
            add(nickel, getSilkTouchOreTable(nickel, regItems.get("raw_nickel")));
            add(silver, getSilkTouchOreTable(silver, regItems.get("raw_silver")));
            add(tin, getSilkTouchOreTable(tin, regItems.get("raw_tin")));
        }
    }
}
