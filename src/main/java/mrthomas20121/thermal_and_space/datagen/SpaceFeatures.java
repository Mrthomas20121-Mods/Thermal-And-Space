package mrthomas20121.thermal_and_space.datagen;

import cofh.thermal.core.common.world.ConfigPlacementFilter;
import earth.terrarium.ad_astra.common.registry.ModBlocks;
import mrthomas20121.thermal_and_space.ThermalAndSpace;
import mrthomas20121.thermal_and_space.init.AstraStone;
import mrthomas20121.thermal_and_space.init.SpaceBlocks;
import mrthomas20121.thermal_and_space.init.ThermalOre;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.ArrayList;
import java.util.List;

public class SpaceFeatures {

    public static class Configured {
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_APATITE = createKey("space_apatite");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_CINNABAR = createKey("space_cinnabar");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_NITER = createKey("space_niter");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_SULFUR = createKey("space_sulfur");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_TIN = createKey("space_tin");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_LEAD = createKey("space_lead");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_SILVER = createKey("space_silver");
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_NICKEL = createKey("space_nickel");

        public static final ResourceKey<ConfiguredFeature<?, ?>> SPACE_OIL_SAND = createKey("space_oil_sand");

        private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ThermalAndSpace.MOD_ID, name));
        }

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            FeatureUtils.register(context, SPACE_APATITE, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.APATITE), 9));
            FeatureUtils.register(context, SPACE_CINNABAR, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.CINNABAR), 5));
            FeatureUtils.register(context, SPACE_NITER, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.NITER), 7));
            FeatureUtils.register(context, SPACE_SULFUR, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.SULFUR), 10));

            FeatureUtils.register(context, SPACE_TIN, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.TIN), 10));
            FeatureUtils.register(context, SPACE_LEAD, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.LEAD), 8));
            FeatureUtils.register(context, SPACE_SILVER, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.SILVER), 8));
            FeatureUtils.register(context, SPACE_NICKEL, Feature.ORE,
                    new OreConfiguration(getOreReplacements(ThermalOre.NICKEL), 8));

            FeatureUtils.register(context, SPACE_OIL_SAND, Feature.ORE,
                    new OreConfiguration(List.of(
                            OreConfiguration.target(new BlockMatchTest(ModBlocks.MOON_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.MOON).get().defaultBlockState()),
                            OreConfiguration.target(new BlockMatchTest(ModBlocks.MARS_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.MARS).get().defaultBlockState()),
                            OreConfiguration.target(new BlockMatchTest(ModBlocks.VENUS_SAND.get()), SpaceBlocks.SAND_ORES.get(AstraStone.VENUS).get().defaultBlockState())
                    ), 24));
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

    public static class Placed {
        public static final ResourceKey<PlacedFeature> SPACE_APATITE = createKey("space_apatite");
        public static final ResourceKey<PlacedFeature> SPACE_CINNABAR = createKey("space_cinnabar");
        public static final ResourceKey<PlacedFeature> SPACE_NITER = createKey("space_niter");
        public static final ResourceKey<PlacedFeature> SPACE_SULFUR = createKey("space_sulfur");
        public static final ResourceKey<PlacedFeature> SPACE_TIN = createKey("space_tin");
        public static final ResourceKey<PlacedFeature> SPACE_LEAD = createKey("space_lead");
        public static final ResourceKey<PlacedFeature> SPACE_SILVER = createKey("space_silver");
        public static final ResourceKey<PlacedFeature> SPACE_NICKEL = createKey("space_nickel");

        public static final ResourceKey<PlacedFeature> SPACE_OIL_SAND = createKey("space_oil_sand");

        private static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ThermalAndSpace.MOD_ID, name));
        }

        public static void bootstrap(BootstapContext<PlacedFeature> context) {

            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

            context.register(SPACE_APATITE, placedOreTriangle(configuredFeatures, Configured.SPACE_APATITE, "space_apatite", -16, 120, 9));
            context.register(SPACE_CINNABAR, placedOreTriangle(configuredFeatures, Configured.SPACE_CINNABAR, "space_cinnabar", -16, 90, 6));
            context.register(SPACE_NITER, placedOreTriangle(configuredFeatures, Configured.SPACE_NITER, "space_niter", -16, 90, 7));
            context.register(SPACE_SULFUR, placedOreTriangle(configuredFeatures, Configured.SPACE_SULFUR, "space_sulfur", -16, 120, 10));
            context.register(SPACE_TIN, placedOreUniform(configuredFeatures, Configured.SPACE_TIN, "space_tin", -20, 120, 10));
            context.register(SPACE_LEAD, placedOreUniform(configuredFeatures, Configured.SPACE_LEAD, "space_lead", -20, 80, 9));
            context.register(SPACE_SILVER, placedOreUniform(configuredFeatures, Configured.SPACE_SILVER, "space_silver", -60, 50, 8));
            context.register(SPACE_NICKEL, placedOreUniform(configuredFeatures, Configured.SPACE_NICKEL, "space_nickel", -40, 120, 8));

            context.register(SPACE_OIL_SAND, placedOreUniform(configuredFeatures, Configured.SPACE_OIL_SAND, "space_oil_sand", 40, 120, 24));
        }

        private static PlacedFeature registerPlacedFeature(HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {

            return new PlacedFeature(getter.getOrThrow(feature), List.of(modifiers));
        }

        private static PlacedFeature placedOreTriangle(HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> ore, String name, int minY, int maxY, int count) {

            return registerPlacedFeature(getter, ore,
                    new ConfigPlacementFilter(name),
                    CountPlacement.of(count),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                    BiomeFilter.biome());
        }

        private static PlacedFeature placedOreUniform(HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> ore, String name, int minY, int maxY, int count) {

            return registerPlacedFeature(getter, ore,
                    new ConfigPlacementFilter(name),
                    CountPlacement.of(count),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(minY), VerticalAnchor.absolute(maxY)),
                    BiomeFilter.biome());
        }
    }
}
