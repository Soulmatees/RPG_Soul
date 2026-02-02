package net.soulmate.rpg_soul.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.soulmate.rpg_soul.RPG_Soul;

import java.util.List;

@JeiPlugin
public class JEIrpg_soulPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(RPG_Soul.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (Minecraft.getInstance().level != null) {
            RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

            // Рецепты для первой машины


            // Рецепты для Fuser

        }
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        // Клик-зона старой машины

        // Клик-зона Fuser (стрелочка)

    }
}