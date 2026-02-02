package net.soulmate.rpg_soul.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.soulmate.rpg_soul.RPG_Soul;

public class ModEntities {
    // Создаем реестр для наших сущностей
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RPG_Soul.MOD_ID);

    // Регистрируем самого SandBug

    // Метод для регистрации в главном классе мода
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}