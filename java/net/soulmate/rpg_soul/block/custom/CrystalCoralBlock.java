package net.soulmate.rpg_soul.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.soulmate.rpg_soul.block.ModBlocks;

import java.util.function.Supplier;

public class CrystalCoralBlock extends FlowerBlock {
    public CrystalCoralBlock(Supplier<MobEffect> effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        // Только кристальный камень.
        return state.is(ModBlocks.HARDENED_SPARKLING_SAND.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos groundPos = pos.below();
        BlockState groundState = level.getBlockState(groundPos);
        // Разрешаем ТОЛЬКО на твой камень
        return groundState.is(ModBlocks.HARDENED_SPARKLING_SAND.get());
    }
}
