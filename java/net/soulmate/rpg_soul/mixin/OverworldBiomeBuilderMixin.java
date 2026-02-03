package net.soulmate.rpg_soul.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.soulmate.rpg_soul.worldgen.biome.ModBiomes;
import net.soulmate.rpg_soul.worldgen.biome.RingingDepthsBiomeParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {
    @Inject(method = "addUndergroundBiomes", at = @At("TAIL"))
    private void rpgSoul$addRingingDepths(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer,
                                         CallbackInfo ci) {
        for (Climate.ParameterPoint point : RingingDepthsBiomeParameters.undergroundParameters()) {
            consumer.accept(Pair.of(point, ModBiomes.RINGING_DEPTHS));
        }
    }
}
