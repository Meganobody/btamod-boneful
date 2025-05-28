package bonefulmod;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.helper.RecipeBuilder;

import static bonefulmod.BonefulMod.MOD_ID;
import static net.minecraft.core.data.registry.Registries.ITEM_GROUPS;

public class StoneTools {

	private static void Override(Item item, String type) {
		String prevkey = item.getKey();
		ModelHelper.setItemModel(item.setKey("stone_bone_"+type), () -> new ItemModelStandard(item, MOD_ID));
		item.setKey(prevkey.substring("item.".length()));
	}

	public static void InitModels() {
		StoneTools.Override(Items.TOOL_AXE_STONE, "axe");
		StoneTools.Override(Items.TOOL_HOE_STONE, "hoe");
		StoneTools.Override(Items.TOOL_PICKAXE_STONE, "pickaxe");
		StoneTools.Override(Items.TOOL_SHOVEL_STONE, "shovel");
		StoneTools.Override(Items.TOOL_SWORD_STONE, "sword");
	}

	public static void InitRecipes() {
		//AXE
		RecipeBuilder.Shaped(MOD_ID,
				"XX", "X#", " #")
			.addInput('X',"minecraft:cobblestones")
			.addInput('#',Items.BONE)
			.create("stone_bone_axe", new ItemStack(Items.TOOL_AXE_STONE));
		//HOE
		RecipeBuilder.Shaped(MOD_ID,
				"XX", " #", " #")
			.addInput('X',"minecraft:cobblestones")
			.addInput('#',Items.BONE)
			.create("stone_bone_hoe", new ItemStack(Items.TOOL_HOE_STONE));
		//PICKAXE
		RecipeBuilder.Shaped(MOD_ID,
				"XXX", " # ", " # ")
			.addInput('X',"minecraft:cobblestones")
			.addInput('#',Items.BONE)
			.create("stone_bone_pickaxe", new ItemStack(Items.TOOL_PICKAXE_STONE));
		//SHOVEL
		RecipeBuilder.Shaped(MOD_ID,
				"X", "#", "#")
			.addInput('X',"minecraft:cobblestones")
			.addInput('#',Items.BONE)
			.create("stone_bone_shovel", new ItemStack(Items.TOOL_SHOVEL_STONE));
		//SWORD
		RecipeBuilder.Shaped(MOD_ID,
				"X", "X", "#")
			.addInput('X',"minecraft:cobblestones")
			.addInput('#',Items.BONE)
			.create("stone_bone_sword", new ItemStack(Items.TOOL_SWORD_STONE));
	}
}
