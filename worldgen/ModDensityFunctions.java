package net.soulmate.rpg_soul.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.worldgen.noise.ModNoises;

public class ModDensityFunctions {
    public static final ResourceKey<DensityFunction> RINGING_CAVE_SHAPE =
            ResourceKey.create(Registries.DENSITY_FUNCTION,
                    ResourceLocation.fromNamespaceAndPath(RPG_Soul.MOD_ID, "ringing_cave_shape"));

    public static void bootstrap(BootstapContext<DensityFunction> context) {
        var noises = context.lookup(Registries.NOISE);


        DensityFunction caveNoise = DensityFunctions.noise(
                noises.getOrThrow(ModNoises.RINGING_CAVES),
                0.01D, 0.01D
        );

        DensityFunction verticalMask = DensityFunctions.yClampedGradient(-40, -20, 0.0, 1.0);
        DensityFunction verticalMaskEnd = DensityFunctions.yClampedGradient(0, 20, 1.0, 0.0);
        DensityFunction combinedMask = DensityFunctions.mul(verticalMask, verticalMaskEnd);
        DensityFunction caveShape = DensityFunctions.mul(
                DensityFunctions.add(caveNoise, DensityFunctions.constant(-0.5D)),
                combinedMask
        );
        DensityFunction finalCaves = DensityFunctions.mul(caveShape, DensityFunctions.constant(-100.0D));

        context.register(RINGING_CAVE_SHAPE, finalCaves);
    }
}
