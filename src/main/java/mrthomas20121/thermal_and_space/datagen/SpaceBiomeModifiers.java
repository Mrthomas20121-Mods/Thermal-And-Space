package mrthomas20121.thermal_and_space.datagen;

import com.google.gson.JsonElement;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.holdersets.AnyHolderSet;

import java.util.HashMap;
import java.util.Map;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.lib.util.helpers.DatapackHelper.datapackProvider;
import static cofh.thermal.lib.FeatureHelper.addFeatureToBiomes;

public class SpaceBiomeModifiers {

    public static JsonCodecProvider<BiomeModifier> dataGenBiomeModifiers(DataGenerator gen, ExistingFileHelper exFileHelper, RegistryOps<JsonElement> regOps) {

        return datapackProvider(ID_THERMAL, gen, exFileHelper, regOps, ForgeRegistries.Keys.BIOME_MODIFIERS, generateBiomeModifiers(regOps.registryAccess));
    }

    private static Map<ResourceLocation, BiomeModifier> generateBiomeModifiers(RegistryAccess registryAccess) {

        Map<ResourceLocation, BiomeModifier> biomeModifierMap = new HashMap<>();

        generateBiomeOres(registryAccess.registryOrThrow(Registry.BIOME_REGISTRY), registryAccess.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY), biomeModifierMap);

        return biomeModifierMap;
    }

    private static void generateBiomeOres(Registry<Biome> biomeRegistry, Registry<PlacedFeature> placedFeatureRegistry, Map<ResourceLocation, BiomeModifier> map) {

        HolderSet<Biome> allBiomes = new AnyHolderSet<>(biomeRegistry);

        addOreToBiomeGen(map, "space_apatite", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_cinnabar", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_niter", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_sulfur", allBiomes, placedFeatureRegistry);

        addOreToBiomeGen(map, "space_tin", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_lead", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_silver", allBiomes, placedFeatureRegistry);
        addOreToBiomeGen(map, "space_nickel", allBiomes, placedFeatureRegistry);

        addOreToBiomeGen(map, "space_oil_sand", allBiomes, placedFeatureRegistry);
    }

    public static void addOreToBiomeGen(Map<ResourceLocation, BiomeModifier> map, String name, HolderSet<Biome> biomes, Registry<PlacedFeature> placedFeatureRegistry) {

        map.put(new ResourceLocation(ID_THERMAL, name + "_biome_spawns"), addFeatureToBiomes(name, biomes, placedFeatureRegistry, GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}
