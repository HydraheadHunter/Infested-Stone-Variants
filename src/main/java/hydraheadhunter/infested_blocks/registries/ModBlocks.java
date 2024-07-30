package hydraheadhunter.infested_blocks.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static hydraheadhunter.infested_blocks.InfestedBlocksHome.MOD_ID;


public class ModBlocks {
	//public static final Block RUBY_BLOCK= registerBlock("ruby_block",
	//new Block( AbstractBlock.Settings.copy(Blocks.GRANITE)));
	
	public static final Block INFESTED_GRANITE 	= registerBlock( "infested_granite"	,
		new InfestedBlock( Blocks.GRANITE	, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));
	
	public static final Block INFESTED_DIORITE 	= registerBlock( "infested_diorite"	,
		new InfestedBlock( Blocks.DIORITE	, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));
	
	public static final Block INFESTED_ANDERSITE = registerBlock( "infested_andesite"	,
		new InfestedBlock( Blocks.ANDESITE	, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));
	
	public static final Block INFESTED_TUFF 	= registerBlock( "infested_tuff"		,
		new InfestedBlock( Blocks.TUFF	, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY)));
	

	public static void registerModBlocks(){
		//InfestedBlocksHome.LOGGER.info("Blocks");
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemsToFunctionalItemGroup);
		
	}
	
	private static Block registerBlock(String name, Block block){
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block );
	}
	
	private static Item registerBlockItem(String name, Block block){
		return Registry.register( Registries.ITEM, Identifier.of(MOD_ID, name),
					new BlockItem(block, new Item.Settings()));
	}
	
	private static void addItemsToFunctionalItemGroup( FabricItemGroupEntries entries){
		entries.add(INFESTED_GRANITE);
		entries.add(INFESTED_DIORITE);
		entries.add(INFESTED_ANDERSITE);
		entries.add(INFESTED_TUFF);
	}
}
