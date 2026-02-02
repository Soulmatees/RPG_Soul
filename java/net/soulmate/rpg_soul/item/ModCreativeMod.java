package net.soulmate.rpg_soul.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.block.ModBlocks;
import net.soulmate.rpg_soul.entity.ModEntities;

public class ModCreativeMod {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPG_Soul.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RPG_SOUL_TAB = CREATIVE_MODE_TABS.register("rpg_soul_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RESONITE.get())) // Иконка обязательна
                    .title(Component.translatable("creativetab.rpg_soul_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RESONITE.get());
                        pOutput.accept(ModItems.RESONITE_INGOT.get());

                        pOutput.accept(ModBlocks.RESONITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RESONITE_INGOT_BLOCK.get());
                        pOutput.accept(ModBlocks.SPARKLING_SAND.get());
                        pOutput.accept(ModBlocks.HARDENED_SPARKLING_SAND.get());
                        pOutput.accept(ModBlocks.ECHO_CLUSTER.get());
                        pOutput.accept(ModBlocks.RESOLITH.get());
                        pOutput.accept(ModBlocks.RESOLITH_STAIRS.get());
                        pOutput.accept(ModBlocks.RESOLITH_SLAB.get());
                        pOutput.accept(ModBlocks.RESOLITH_WALL.get());
                        pOutput.accept(ModBlocks.RESOLITH_BUTTON.get());
                        pOutput.accept(ModBlocks.RESOLITH_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH_BUTTON.get());
                        pOutput.accept(ModBlocks.POLISHED_RESOLITH_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.HARDENED_QUARTZITE.get());
                        pOutput.accept(ModBlocks.HARDENED_QUARTZITE.get());
                        pOutput.accept(ModBlocks.HARDENED_QUARTZITE.get());
                        pOutput.accept(ModBlocks.HARDENED_QUARTZITE.get());
                        pOutput.accept(ModBlocks.HARDENED_QUARTZITE.get());


                        pOutput.accept(ModBlocks.CRYSTAL_CORAL.get());
                        pOutput.accept(ModBlocks.CRYSTAL_GRASS.get());
                        pOutput.accept(ModBlocks.BELFRY.get());



                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}