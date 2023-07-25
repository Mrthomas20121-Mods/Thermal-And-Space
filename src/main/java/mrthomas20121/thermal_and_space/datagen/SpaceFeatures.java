package mrthomas20121.thermal_and_space.datagen;

import com.google.gson.JsonElement;
import earth.terrarium.ad_astra.common.registry.ModBlocks;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cofh.lib.util.helpers.DatapackHelper.datapackProvider;
import static cofh.thermal.lib.FeatureHelper.createOreFeature;

public class SpaceFeatures {

    public static JsonCodecProvider<PlacedFeature> dataGenFeatures(DataGenerator gen, ExistingFileHelper exFileHelper, RegistryOps<JsonElement> regOps) {

        return datapackProvider(ThermalAndSpace.MOD_ID, gen, exFileHelper, regOps, Registry.PLACED_FEATURE_REGISTRY, generateFeatures(regOps.registryAccess.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY)));
    }

    private static Map<ResourceLocation, PlacedFeature> generateFeatures(Registry<PlacedFeature> featureRegistry) {

        Map<ResourceLocation, PlacedFeature> featureMap = new HashMap<>();

        generateOres(featureMap);

        return featureMap;
    }

    private static void generateOres(Map<ResourceLocation, PlacedFeature> featureMap) {

        createOreFeature(featureMap, getOreReplacements(ThermalOre.APATITE), "space_apatite", 3, -16, 120, 9);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.CINNABAR), "space_cinnabar", 1, -16, 90, 5);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.NITER), "space_niter", 2, -16, 90, 7);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.SULFUR), "space_sulfur", 2, -16, 62, 7);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.TIN), "space_tin", 6, -60, 60, 9);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.LEAD), "space_lead", 6, -20, 80, 9);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.SILVER), "space_silver", 4, -60, 50, 8);
        createOreFeature(featureMap, getOreReplacements(ThermalOre.NICKEL), "space_nickel", 4, -40, 120, 8);

        createOreFeature(featureMap, List.of(
                OreConfiguration.target(new BlockMatchTest(ModBlocks.MOON_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.MOON).get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(ModBlocks.MARS_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.MARS).get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(ModBlocks.VENUS_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.VENUS).get().defaultBlockState())
        ), "space_oil_sand", 4, 40, 120, 24);
    }

    public static List<OreConfiguration.TargetBlockState> getOreReplacements(ThermalOre ore) {

        final List<OreConfiguration.TargetBlockState> oreReplacements = new ArrayList<>();

        for(AstraStone stone: ore.getStones()) {
            SpaceBlocks.ORES.get(stone).get(ore).ifPresent(oreBlock ->
                    oreReplacements.add(OreConfiguration.target(stone.getTag(), oreBlock.defaultBlockState())));
        }

        return oreReplacements;
    }
}
