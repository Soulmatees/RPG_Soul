package net.soulmate.rpg_soul.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.block.custom.CrystalBushBlock;
import net.soulmate.rpg_soul.block.custom.CrystalCoralBlock;
import net.soulmate.rpg_soul.block.custom.HardenedQuartziteBlock;
import net.soulmate.rpg_soul.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RPG_Soul.MOD_ID);

    //region 1. RESONITE & ORES
    public static RegistryObject<Block> RESONITE_BLOCK = registerBlock("resonite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> RESONITE_INGOT_BLOCK = registerBlock("resonite_ingot_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> ECHO_CLUSTER = registerBlock("echo_cluster",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> SPARKLING_SAND = registerBlock("sparkling_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> HARDENED_SPARKLING_SAND = registerBlock("hardened_sparkling_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> RESOLITH = registerBlock("resolith",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    public static RegistryObject<Block> POLISHED_RESOLITH = registerBlock("polished_resolith",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.SAND)));
    //region
    public static final RegistryObject<Block> RESOLITH_STAIRS = registerBlock("resolith_stairs",
            () -> new StairBlock(() -> ModBlocks.RESOLITH.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> RESOLITH_SLAB = registerBlock("resolith_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> RESOLITH_WALL = registerBlock("resolith_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> RESOLITH_BUTTON = registerBlock("resolith_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get()),
                    BlockSetType.STONE, 20, false));
    public static final RegistryObject<Block> RESOLITH_PRESSURE_PLATE = registerBlock("resolith_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get()), BlockSetType.STONE));

    public static final RegistryObject<Block> POLISHED_RESOLITH_STAIRS = registerBlock("polished_resolith_stairs",
            () -> new StairBlock(() -> ModBlocks.RESOLITH.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> POLISHED_RESOLITH_SLAB = registerBlock("polished_resolith_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> POLISHED_RESOLITH_WALL = registerBlock("polished_resolith_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get())));

    public static final RegistryObject<Block> POLISHED_RESOLITH_BUTTON = registerBlock("polished_resolith_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get()),
                    BlockSetType.STONE, 20, false));
    public static final RegistryObject<Block> POLISHED_RESOLITH_PRESSURE_PLATE = registerBlock("polished_resolith_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(ModBlocks.RESOLITH.get()), BlockSetType.STONE));
    //endregion
    public static final RegistryObject<Block> HARDENED_QUARTZITE = registerBlock("hardened_quartzite",
            () -> new HardenedQuartziteBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
                    .sound(SoundType.SAND)
                    .lightLevel((state) -> 15) // Максимум 15
                    .noOcclusion()// Если не хочешь, чтобы он выпадал без шелкового касания
            ));
    public static final RegistryObject<Block> CRYSTAL_GRASS = registerBlock("crystal_grass",
            () -> new CrystalBushBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noOcclusion()));

    public static final RegistryObject<Block> BELFRY = registerBlock("belfry",
            () -> new CrystalBushBlock(BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion()));

    // Коралл (только на кристальный камень)
    public static final RegistryObject<Block> CRYSTAL_CORAL = registerBlock("crystal_coral",
            () -> new CrystalCoralBlock(() -> MobEffects.GLOWING, 5,
                    BlockBehaviour.Properties.copy(Blocks.PINK_PETALS)
                            .noOcclusion()
                            .lightLevel((state) -> 7)));

    //endregion


    //region HELPERS & REGISTRATION
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new  Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    //endregion
}