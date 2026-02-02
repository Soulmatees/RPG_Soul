package net.soulmate.rpg_soul.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3f;

public class HardenedQuartziteBlock extends Block {
    public HardenedQuartziteBlock(Properties properties) {
        super(properties);
    }

    // Этот метод убирает отрисовку граней между одинаковыми блоками
    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pSide) {
        if (pAdjacentBlockState.is(this)) {
            return true;
        }

        return super.skipRendering(pState, pAdjacentBlockState, pSide);
    }
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) { // Шанс появления частицы
            double d0 = (double)pos.getX() + random.nextDouble();
            double d1 = (double)pos.getY() + random.nextDouble();
            double d2 = (double)pos.getZ() + random.nextDouble();
            // Используем частицы пыли нужного цвета (Redstone Particle может быть любого цвета)
            // Цвет розовый: Red 1.0, Green 0.5, Blue 0.8
            level.addParticle(new DustParticleOptions(new Vector3f(1.0f, 0.5f, 0.8f), 1.0f), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
}