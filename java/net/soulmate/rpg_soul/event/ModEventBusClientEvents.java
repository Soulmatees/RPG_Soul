package net.soulmate.rpg_soul.event;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.block.ModBlocks;
import net.soulmate.rpg_soul.block.entity.ModBlockEntities;
import net.soulmate.rpg_soul.entity.ModEntities;
import net.soulmate.rpg_soul.entity.client.ModModelLayers;
import net.soulmate.rpg_soul.screen.ModMenuTypes;

// ВАЖНО: value = Dist.CLIENT говорит, что этот код не должен запускаться на сервере
@Mod.EventBusSubscriber(modid = RPG_Soul.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // РЕГИСТРАЦИЯ СЛОЕВ (моделей)
        // Здесь мы говорим Forge, какую 3D-сетку использовать для лодки
    }
}