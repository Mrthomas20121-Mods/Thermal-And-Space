package mrthomas20121.thermal_and_space.datagen;

import cofh.thermal.foundation.init.data.worldgen.TFndBiomeModifiers;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.holdersets.AnyHolderSet;

import java.util.HashMap;
import java.util.Map;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES;

public class SpaceBiomeModifiers {

    public static final ResourceKey<BiomeModifier> SPACE_APATITE_ORE = createKey("space_ore_apatite");
    public static final ResourceKey<BiomeModifier> SPACE_CINNABAR_ORE = createKey("space_ore_cinnabar");
    public static final ResourceKey<BiomeModifier> SPACE_NITER_ORE = createKey("space_ore_niter");
    public static final ResourceKey<BiomeModifier> SPACE_SULFUR_ORE = createKey("space_ore_sulfur");

    public static final ResourceKey<BiomeModifier> SPACE_LEAD_ORE = createKey("space_ore_lead");
    public static final ResourceKey<BiomeModifier> SPACE_NICKEL_ORE = createKey("space_ore_nickel");
    public static final ResourceKey<BiomeModifier> SPACE_SILVER_ORE = createKey("space_ore_silver");
    public static final ResourceKey<BiomeModifier> SPACE_TIN_ORE = createKey("space_ore_tin");

    public static final ResourceKey<BiomeModifier> SPACE_OIL_SAND = createKey("space_oil_sand");

    private static ResourceKey<BiomeModifier> createKey(String name) {

        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ID_THERMAL, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var isOverworldTag = context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD);

        registerOre(context, SPACE_APATITE_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_APATITE);
        registerOre(context, SPACE_CINNABAR_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_CINNABAR);
        registerOre(context, SPACE_NITER_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_NITER);
        registerOre(context, SPACE_SULFUR_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_SULFUR);

        registerOre(context, SPACE_LEAD_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_LEAD);
        registerOre(context, SPACE_NICKEL_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_NICKEL);
        registerOre(context, SPACE_SILVER_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_SILVER);
        registerOre(context, SPACE_TIN_ORE, isOverworldTag, SpaceFeatures.Placed.SPACE_TIN);
    }

    private static void registerOre(BootstapContext<BiomeModifier> context, ResourceKey<BiomeModifier> biomeMod, HolderSet<Biome> biomes, ResourceKey<PlacedFeature> feature) {

        context.register(biomeMod, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes,
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(feature)),
                UNDERGROUND_ORES));
    }
}
