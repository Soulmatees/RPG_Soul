package net.soulmate.rpg_soul.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.entity.ModEntities;

// ВАЖНО: здесь добавляется bus = Mod.EventBusSubscriber.Bus.MOD
@Mod.EventBusSubscriber(modid = RPG_Soul.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        // Привязываем характеристики к твоему жуку

    }
}