package mrthomas20121.thermal_and_space.init;

import cofh.lib.tags.BlockTagsCoFH;
import cofh.lib.tags.ItemTagsCoFH;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Locale;

public enum ThermalOre {
    APATITE(AstraStone.MOON, AstraStone.MARS, AstraStone.VENUS),
    CINNABAR(AstraStone.MOON, AstraStone.MARS, AstraStone.VENUS),
    LEAD(AstraStone.VENUS, AstraStone.GLACIO, AstraStone.MARS),
    NICKEL(AstraStone.MERCURY, AstraStone.MOON),
    NITER(AstraStone.MERCURY, AstraStone.GLACIO, AstraStone.MOON),
    RUBY(AstraStone.MARS, AstraStone.VENUS, AstraStone.MOON),
    SAPPHIRE(AstraStone.MERCURY, AstraStone.VENUS),
    SILVER(AstraStone.MOON, AstraStone.MARS, AstraStone.MERCURY, AstraStone.VENUS),
    SULFUR(AstraStone.MARS, AstraStone.MERCURY),
    TIN(AstraStone.MOON, AstraStone.MERCURY, AstraStone.VENUS, AstraStone.MARS, AstraStone.GLACIO);

    private final AstraStone[] stones;

    ThermalOre(AstraStone... stones) {
        this.stones = stones;
    }

    public String getOreName(String stone) {
        return "%s_%s_ore".formatted(stone, this.name().toLowerCase(Locale.ROOT));
    }

    public TagKey<Block> getBlockTagKey() {
        switch (this) {
            case APATITE -> {
                return BlockTagsCoFH.ORES_APATITE;
            }
            case CINNABAR -> {
                return BlockTagsCoFH.ORES_CINNABAR;
            }
            case LEAD -> {
                return BlockTagsCoFH.ORES_LEAD;
            }
            case NICKEL -> {
                return BlockTagsCoFH.ORES_NICKEL;
            }
            case NITER -> {
                return BlockTagsCoFH.ORES_NITER;
            }
            case RUBY -> {
                return BlockTagsCoFH.ORES_RUBY;
            }
            case SAPPHIRE -> {
                return BlockTagsCoFH.ORES_SAPPHIRE;
            }
            case SILVER -> {
                return BlockTagsCoFH.ORES_SILVER;
            }
            case SULFUR -> {
                return BlockTagsCoFH.ORES_SULFUR;
            }
            case TIN -> {
                return BlockTagsCoFH.ORES_TIN;
            }
            default -> {
                return null;
            }
        }
    }

    public TagKey<Item> getItemTagKey() {
        switch (this) {
            case APATITE -> {
                return ItemTagsCoFH.ORES_APATITE;
            }
            case CINNABAR -> {
                return ItemTagsCoFH.ORES_CINNABAR;
            }
            case LEAD -> {
                return ItemTagsCoFH.ORES_LEAD;
            }
            case NICKEL -> {
                return ItemTagsCoFH.ORES_NICKEL;
            }
            case NITER -> {
                return ItemTagsCoFH.ORES_NITER;
            }
            case RUBY -> {
                return ItemTagsCoFH.ORES_RUBY;
            }
            case SAPPHIRE -> {
                return ItemTagsCoFH.ORES_SAPPHIRE;
            }
            case SILVER -> {
                return ItemTagsCoFH.ORES_SILVER;
            }
            case SULFUR -> {
                return ItemTagsCoFH.ORES_SULFUR;
            }
            case TIN -> {
                return ItemTagsCoFH.ORES_TIN;
            }
            default -> {
                return null;
            }
        }
    }

    public AstraStone[] getStones() {
        return stones;
    }
}
