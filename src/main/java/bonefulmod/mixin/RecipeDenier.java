package bonefulmod.mixin;

import net.minecraft.core.data.registry.recipe.RecipeEntryBase;
import net.minecraft.core.data.registry.recipe.RecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

import static bonefulmod.BonefulMod.LOGGER;
import static bonefulmod.BonefulMod.MOD_ID;

@Mixin(
	value = {RecipeRegistry.class},
	remap = false
)
public class RecipeDenier {
	private static List ToDeny = new ArrayList<String>();
	static {
		ToDeny.add("minecraft:workbench/stone_axe");
		ToDeny.add("minecraft:workbench/stone_hoe");
		ToDeny.add("minecraft:workbench/stone_pickaxe");
		ToDeny.add("minecraft:workbench/stone_shovel");
		ToDeny.add("minecraft:workbench/stone_sword");
	}

	@Inject(method = "addCustomRecipe", at = @At("HEAD"), cancellable = true)
	private void RecipeDenierInject(String recipeKey, RecipeEntryBase<?, ?, ?> recipe, CallbackInfo ci) {
		if (ToDeny.contains(recipeKey)) {
			LOGGER.info("Recipe "+recipeKey+" is denied in Mixin");
			ci.cancel();
		}
	}
}
