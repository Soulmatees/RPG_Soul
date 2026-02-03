package net.soulmate.rpg_soul.mixin;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.soulmate.rpg_soul.worldgen.biome.ModBiomes;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {

    @Inject(method = "addBiomes", at = @At("TAIL"))
    private void injectModBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, CallbackInfo ci) {
        Climate.ParameterPoint ringingDepthsPoint = Climate.parameters(
                Climate.Parameter.span(-0.2F, 0.2F), // Temperature
                Climate.Parameter.span(-0.2F, 0.2F), // Humidity
                Climate.Parameter.span(0.4F, 1.0F),  // Continentalness (суша)
                Climate.Parameter.span(-0.1F, 0.1F), // Erosion
                Climate.Parameter.span(0.8F, 1.0F),  // Depth (глубоко под землей/пещеры)
                Climate.Parameter.span(0.5F, 1.0F),  // Weirdness
                0.0F                                 // Offset
        );
        mapper.accept(Pair.of(ringingDepthsPoint, ModBiomes.RINGING_DEPTHS));
    }
}