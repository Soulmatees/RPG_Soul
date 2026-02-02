package net.soulmate.rpg_soul.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.soulmate.rpg_soul.RPG_Soul;

public class ModItems {
    public static final  DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RPG_Soul.MOD_ID);

    public static final RegistryObject<Item> RESONITE = ITEMS.register("resonite",
            () -> new Item(new  Item.Properties()));
    public static final RegistryObject<Item> RESONITE_INGOT = ITEMS.register("resonite_ingot",
            () -> new Item(new  Item.Properties()));


    public  static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
