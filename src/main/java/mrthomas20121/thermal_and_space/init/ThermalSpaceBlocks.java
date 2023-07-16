package mrthomas20121.thermal_and_space.init;

import cofh.lib.block.OreBlockCoFH;
import cofh.thermal.lib.common.ThermalItemGroups;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// credit to the tfc devs for the mapOfKeys methods
public class ThermalSpaceBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ThermalAndSpace.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalAndSpace.MOD_ID);

    public static Map<AstraStone, Map<ThermalOre, RegistryObject<OreBlockCoFH>>> ORES = mapOfKeys(AstraStone.class, stone -> mapOfKeys(ThermalOre.class, ore -> registerOre(ore.getOreName(stone.name().toLowerCase(Locale.ROOT)), stone)));
    public static Map<AstraStone, RegistryObject<FallingBlock>> SAND_ORES = mapOfKeys(AstraStone.class, AstraStone::isSand, stone -> registerSandOre("oil_%s_sand".formatted(stone.name().toLowerCase(Locale.ROOT)), stone));

    /**
     * Creates a map of each enum constant to the value as provided by the value mapper.
     */
    public static <E extends Enum<E>, V> EnumMap<E, V> mapOfKeys(Class<E> enumClass, Function<E, V> valueMapper)
    {
        return mapOfKeys(enumClass, key -> true, valueMapper);
    }

    /**
     * Creates a map of each enum constant to the value as provided by the value mapper, only using enum constants that match the provided predicate.
     */
    public static <E extends Enum<E>, V> EnumMap<E, V> mapOfKeys(Class<E> enumClass, Predicate<E> keyPredicate, Function<E, V> valueMapper)
    {
        return Arrays.stream(enumClass.getEnumConstants()).filter(keyPredicate).collect(Collectors.toMap(Function.identity(), valueMapper, (v, v2) -> v, () -> new EnumMap<>(enumClass)));
    }

    private static RegistryObject<FallingBlock> registerSandOre(String name, AstraStone stone) {
        RegistryObject<FallingBlock> block = BLOCKS.register(name, () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).color(stone.getColor())));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ThermalItemGroups.THERMAL_BLOCKS)));
        return block;
    }

    private static RegistryObject<OreBlockCoFH> registerOre(String name, AstraStone stone) {
        RegistryObject<OreBlockCoFH> block = BLOCKS.register(name, () -> new OreBlockCoFH(BlockBehaviour.Properties.of(Material.STONE, stone.getColor()).strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ThermalItemGroups.THERMAL_BLOCKS)));
        return block;
    }
}
