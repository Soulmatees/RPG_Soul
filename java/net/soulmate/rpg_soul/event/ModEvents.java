package net.soulmate.rpg_soul.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.soulmate.rpg_soul.RPG_Soul;
import net.soulmate.rpg_soul.block.ModBlocks;
import net.soulmate.rpg_soul.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = RPG_Soul.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    /**
     * ЛОГИКА ТОПЛИВА (PRO)
     * Автоматически делает все предметы из тега #minecraft:planks (доски) топливом.
     */
    @SubscribeEvent
    public static void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemStack = event.getItemStack();

        // Проверяем, входит ли предмет в ванильный тег досок
        // Это подхватит твои TREE_DROUGHT_PLANKS, если они добавлены в тег в DataGen
        if (itemStack.is(ItemTags.PLANKS)) {
            // 300 тиков = время горения 1.5 предметов (стандарт для досок)
            event.setBurnTime(300);
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

        // Сделки для ФЕРМЕРА
        if (event.getType() == VillagerProfession.FARMER) {
            trades.get(1).add((pEntity, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.RESONITE.get(), 6),
                    10, 8, 0.02f));
        }

        // Сделки для БРОННИКА
        if (event.getType() == VillagerProfession.ARMORER) {
            trades.get(3).add((pEntity, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RESONITE_INGOT.get(), 1),
                    new ItemStack(Items.EMERALD, 5),
                    6, 12, 0.05f));
        }
        // Сделки для твоего кастомного жителя SOUND_MASTER
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        // Странствующий торговец: 5 изумрудов -> семена
        event.getGenericTrades().add((pEntity, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 5),
                new ItemStack(ModItems.RESONITE.get(), 1),
                12, 12, 0.2f));
    }

    /**
     * PRO Хелпер: сокращает код регистрации сделок
     */
    private static void addTrade(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int level, ItemStack input, ItemStack output, int maxUses, int xp) {
        trades.get(level).add((pEntity, pRandom) -> new MerchantOffer(input, output, maxUses, xp, 0.05f));
    }
}