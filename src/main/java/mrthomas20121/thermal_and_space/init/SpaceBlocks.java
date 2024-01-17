package mrthomas20121.thermal_and_space.init;

import cofh.lib.common.block.OreBlockCoFH;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.util.Helpers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.Map;

// credit to the tfc devs for the mapOfKeys methods
public class SpaceBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ThermalAndSpace.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalAndSpace.MOD_ID);

    public static Map<AstraStone, Map<ThermalOre, RegistryObject<OreBlockCoFH>>> ORES = Helpers.mapOfKeys(AstraStone.class, stone -> Helpers.mapOfKeys(ThermalOre.class, ore -> registerOre(ore.getOreName(stone.name().toLowerCase(Locale.ROOT)), stone)));
    public static Map<AstraStone, RegistryObject<FallingBlock>> SAND_ORES = Helpers.mapOfKeys(AstraStone.class, AstraStone::isSand, stone -> registerSandOre("oil_%s_sand".formatted(stone.name().toLowerCase(Locale.ROOT))));

    private static RegistryObject<FallingBlock> registerSandOre(String name) {
        RegistryObject<FallingBlock> block = BLOCKS.register(name, () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<OreBlockCoFH> registerOre(String name, AstraStone stone) {
        RegistryObject<OreBlockCoFH> block = BLOCKS.register(name, () -> new OreBlockCoFH(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
