package net.soulmate.rpg_soul.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.soulmate.rpg_soul.RPG_Soul;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RPG_Soul.MOD_ID);


    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> RESONITE_INGOT_BLOCK_BREAK = registerSoundEvents("resonite_ingot_block_break");
    public static final RegistryObject<SoundEvent> RESONITE_INGOT_BLOCK_STEP = registerSoundEvents("resonite_ingot_block_step");
    public static final RegistryObject<SoundEvent> RESONITE_INGOT_BLOCK_FALL = registerSoundEvents("resonite_ingot_block_fall");
    public static final RegistryObject<SoundEvent> RESONITE_INGOT_BLOCK_PLACE = registerSoundEvents("resonite_ingot_block_place");
    public static final RegistryObject<SoundEvent> RESONITE_INGOT_BLOCK_HIT = registerSoundEvents("resonite_ingot_block_hit");

    public static final ForgeSoundType RESONITE_INGOT_BLOCK_SOUND = new ForgeSoundType(1f,1f,
            ModSounds.RESONITE_INGOT_BLOCK_BREAK, ModSounds.RESONITE_INGOT_BLOCK_STEP, ModSounds.RESONITE_INGOT_BLOCK_PLACE,
            ModSounds.RESONITE_INGOT_BLOCK_HIT, ModSounds.RESONITE_INGOT_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(RPG_Soul.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
