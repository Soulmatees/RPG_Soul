package net.soulmate.rpg_soul.worldgen.biome;

import net.minecraft.world.level.biome.Climate;

import java.util.List;

public final class RingingDepthsBiomeParameters {
    private static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter HUMIDITY = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter EROSION = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter DEPTH = Climate.Parameter.span(0.25F, 1.0F);
    private static final Climate.Parameter WEIRDNESS = Climate.Parameter.span(-1.0F, 1.0F);
    private static final float OFFSET = 0.0F;

    private RingingDepthsBiomeParameters() {
    }

    public static List<Climate.ParameterPoint> undergroundParameters() {
        return List.of(
                Climate.parameters(
                        TEMPERATURE,
                        HUMIDITY,
                        CONTINENTALNESS,
                        EROSION,
                        DEPTH,
                        WEIRDNESS,
                        OFFSET
                ),
                Climate.parameters(
                        TEMPERATURE,
                        HUMIDITY,
                        CONTINENTALNESS,
                        EROSION,
                        Climate.Parameter.span(0.4F, 1.0F),
                        Climate.Parameter.span(-0.6F, 0.6F),
                        OFFSET
                )
        );
    }
}
