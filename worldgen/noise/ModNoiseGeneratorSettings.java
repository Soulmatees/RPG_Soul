package net.soulmate.rpg_soul.worldgen.noise;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.worldgen.ModDensityFunctions;
import net.soulmate.rpg_soul.worldgen.ModSurfaceRules;

import java.util.List;

public class ModNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> RINGING_SETTINGS = ResourceKey.create(
            Registries.NOISE_SETTINGS,
            ResourceLocation.fromNamespaceAndPath(RPG_Soul.MOD_ID, "ringing_settings")
    );

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        var densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);

        // Создаем ссылку на вашу функцию плотности через Holder
        DensityFunction caveShape = new DensityFunctions.HolderHolder(
                densityFunctions.getOrThrow(ModDensityFunctions.RINGING_CAVE_SHAPE)
        );

        // Полезная заглушка (ноль)
        DensityFunction zero = DensityFunctions.zero();

        NoiseSettings noiseSettings = NoiseSettings.create(-64, 384, 1, 2);

        context.register(RINGING_SETTINGS, new NoiseGeneratorSettings(
                noiseSettings,
                Blocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                new NoiseRouter(
                        zero,      // barrier
                        zero,      // fluid level floodedness
                        zero,      // fluid level spread
                        zero,      // lava
                        zero,      // temperature
                        zero,      // vegetation
                        zero,      // continents
                        zero,      // erosion
                        zero,      // depth
                        zero,      // weirdness
                        zero,      // initial density
                        caveShape, // final density (ВАША ФОРМА ТУТ)
                        zero,      // veined ridge
                        zero,      // veined gap
                        zero       // veined ridged weirdness
                ),
                ModSurfaceRules.makeRules(),
                List.of(), // Spawn targets
                63,
                false,
                true,
                false,
                false
        ));
    }
}