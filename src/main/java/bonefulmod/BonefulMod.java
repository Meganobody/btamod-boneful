package bonefulmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.ModelEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class BonefulMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint, ModelEntrypoint {
    public static final String MOD_ID = "bonefulmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("BONEFUL initialized.");
    }

	@Override
	public void beforeGameStart() {}

	@Override
	public void afterGameStart() {}

	@Override
	public void onRecipesReady() { StoneTools.InitRecipes(); }

	@Override
	public void initNamespaces() {}

	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {}
	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) { StoneTools.InitModels(); }
	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {}
	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {}
	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {}
}
