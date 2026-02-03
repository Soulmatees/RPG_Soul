package net.soulmate.rpg_soul.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.soulmate.rpg_soul.worldgen.ModDensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseRouterData.class)
public class NoiseRouterDataMixin {

    @Inject(method = "overworld", at = @At("RETURN"), cancellable = true)
    private static void injectCustomCaves(HolderGetter<DensityFunction> functions, HolderGetter<NormalNoise.NoiseParameters> noise, boolean amplified, boolean largeBiomes, CallbackInfoReturnable<NoiseRouter> cir) {
        NoiseRouter original = cir.getReturnValue();

        Holder.Reference<DensityFunction> customShapeHolder = functions.getOrThrow(ModDensityFunctions.RINGING_CAVE_SHAPE);
        DensityFunction myCustomShape = customShapeHolder.value();

        NoiseRouter modifiedRouter = new NoiseRouter(
                original.barrierNoise(),
                original.fluidLevelFloodednessNoise(),
                original.fluidLevelSpreadNoise(),
                original.lavaNoise(),
                original.temperature(),
                original.vegetation(),
                original.continents(),
                original.erosion(),
                original.depth(),
                original.ridges(),
                original.initialDensityWithoutJaggedness(),
                original.finalDensity(),
                DensityFunctions.add(original.veinToggle(), myCustomShape),
                original.veinRidged(),
                original.veinGap()
        );

        cir.setReturnValue(modifiedRouter);
    }
}