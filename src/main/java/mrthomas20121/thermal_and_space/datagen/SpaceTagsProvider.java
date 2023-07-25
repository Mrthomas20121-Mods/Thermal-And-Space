package mrthomas20121.thermal_and_space.datagen;

import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SpaceTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
            super(generator, ThermalAndSpace.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            ThermalOre[] ores = ThermalOre.values();
            AstraStone[] stones = AstraStone.values();

            for(AstraStone stone : stones) {

                if(stone.isSand()) {
                    this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(SpaceBlocks.SAND_ORES.get(stone).get());
                }

                for(ThermalOre ore: ores) {

                    this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SpaceBlocks.ORES.get(stone).get(ore).get());

                    if(ore.getBlockTagKey() != null) {
                        this.tag(ore.getBlockTagKey()).add(SpaceBlocks.ORES.get(stone).get(ore).get());
                    }
                }
            }
        }
    }

    public static class Item extends ItemTagsProvider {

        public Item(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_126530_, p_126531_, "thermal", existingFileHelper);
        }

        @Override
        protected void addTags() {
            ThermalOre[] ores = ThermalOre.values();
            AstraStone[] stones = AstraStone.values();

            for(AstraStone stone : stones) {

                for(ThermalOre ore: ores) {
                    if(ore.getItemTagKey() != null) {
                        this.tag(ore.getItemTagKey()).add(SpaceBlocks.ORES.get(stone).get(ore).get().asItem());
                    }
                }
            }
        }
    }
}
