package net.darkhax.darkutils.handler;

import static net.darkhax.bookshelf.lib.util.OreDictUtils.BLOCK_REDSTONE;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.BLOCK_SLIME;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.BONE;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.CROP_WHEAT;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.EGG;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.ENDERPEARL;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.GEM_EMERALD;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.GUNPOWDER;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.INGOT_IRON;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.OBSIDIAN;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.PANE_GLASS;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.SLIMEBALL;
import static net.darkhax.bookshelf.lib.util.OreDictUtils.STONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.darkhax.bookshelf.common.BookshelfRegistry;
import net.darkhax.bookshelf.item.ItemBlockBasic;
import net.darkhax.bookshelf.lib.util.ItemStackUtils;
import net.darkhax.darkutils.DarkUtils;
import net.darkhax.darkutils.blocks.BlockAntiSlime;
import net.darkhax.darkutils.blocks.BlockCakeBase;
import net.darkhax.darkutils.blocks.BlockEnderTether;
import net.darkhax.darkutils.blocks.BlockFakeTNT;
import net.darkhax.darkutils.blocks.BlockFeeder;
import net.darkhax.darkutils.blocks.BlockFilter;
import net.darkhax.darkutils.blocks.BlockGrate;
import net.darkhax.darkutils.blocks.BlockShulkerPearl;
import net.darkhax.darkutils.blocks.BlockTimer;
import net.darkhax.darkutils.blocks.BlockTrapEffect;
import net.darkhax.darkutils.blocks.BlockUpdateDetector;
import net.darkhax.darkutils.blocks.BlockVectorPlate;
import net.darkhax.darkutils.blocks.sneaky.BlockSneaky;
import net.darkhax.darkutils.blocks.sneaky.BlockSneakyGhost;
import net.darkhax.darkutils.blocks.sneaky.BlockSneakyLever;
import net.darkhax.darkutils.blocks.sneaky.BlockSneakyObsidian;
import net.darkhax.darkutils.blocks.sneaky.BlockSneakyPressurePlate;
import net.darkhax.darkutils.blocks.sneaky.BlockSneakyTorch;
import net.darkhax.darkutils.entity.EntityFakeTNT;
import net.darkhax.darkutils.items.ItemBlockCake;
import net.darkhax.darkutils.items.ItemBlockFilter;
import net.darkhax.darkutils.items.ItemMaterial;
import net.darkhax.darkutils.items.ItemMysteriousPotion;
import net.darkhax.darkutils.items.ItemPortalCharm;
import net.darkhax.darkutils.tileentity.TileEntityAntiSlime;
import net.darkhax.darkutils.tileentity.TileEntityEnderTether;
import net.darkhax.darkutils.tileentity.TileEntityFeeder;
import net.darkhax.darkutils.tileentity.TileEntityShulkerPearl;
import net.darkhax.darkutils.tileentity.TileEntitySneaky;
import net.darkhax.darkutils.tileentity.TileEntityTimer;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ContentHandler {
    
    /**
     * A list of all items from DarkUtils.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();
    
    /**
     * A list of all blocks from DarkUtils.
     */
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    
    public static Block blockTrap;
    public static Block blockEnderTether;
    public static Block blockTrapMovement;
    public static Block blockTrapMovementFast;
    public static Block blockTrapMovementHyper;
    public static Block blockGrate;
    public static Block blockFilter;
    public static Block blockTimer;
    public static Block blockAntiSlime;
    public static Block blockDetector;
    public static Block blockCakeEPlus;
    public static Block blockSneakyBlock;
    public static Block blockSneakyLever;
    public static Block blockSneakyGhost;
    public static Block blockSneakyTorch;
    public static Block blockSneakyObsidian;
    public static Block blockSneakyPlate;
    public static Block blockFeeder;
    public static Block blockFakeTNT;
    public static Block blockShulkerPearl;
    
    public static Item itemMaterial;
    public static Item itemPotion;
    public static Item itemCharmVoid;
    public static Item itemCharmPortal;
    
    public static void initBlocks () {
        
        blockTrap = new BlockTrapEffect();
        registerBlock(blockTrap, new ItemBlockBasic(blockTrap, BlockTrapEffect.EnumType.getTypes()), "trap_tile");
        
        blockEnderTether = new BlockEnderTether();
        registerBlock(blockEnderTether, "ender_tether");
        GameRegistry.registerTileEntity(TileEntityEnderTether.class, "ender_tether");
        
        blockTrapMovement = new BlockVectorPlate(0.06d);
        registerBlock(blockTrapMovement, "trap_move");
        
        blockTrapMovementFast = new BlockVectorPlate(0.3d);
        registerBlock(blockTrapMovementFast, "trap_move_fast");
        
        blockTrapMovementHyper = new BlockVectorPlate(1.5d);
        registerBlock(blockTrapMovementHyper, "trap_move_hyper");
        
        blockGrate = new BlockGrate();
        registerBlock(blockGrate, "grate");
        
        blockFilter = new BlockFilter();
        registerBlock(blockFilter, new ItemBlockFilter(blockFilter, BlockFilter.EnumType.getTypes()), "filter");
        
        blockTimer = new BlockTimer();
        registerBlock(blockTimer, "timer");
        GameRegistry.registerTileEntity(TileEntityTimer.class, "timer");
        
        blockAntiSlime = new BlockAntiSlime();
        registerBlock(blockAntiSlime, "anti_slime");
        GameRegistry.registerTileEntity(TileEntityAntiSlime.class, "anti_slime");
        
        blockDetector = new BlockUpdateDetector();
        registerBlock(blockDetector, "update_detector");
        
        blockCakeEPlus = new BlockCakeBase("eplus");
        registerBlock(blockCakeEPlus, new ItemBlockCake(blockCakeEPlus), "cake_eplus");
        
        blockSneakyBlock = new BlockSneaky();
        registerBlock(blockSneakyBlock, "sneaky");
        GameRegistry.registerTileEntity(TileEntitySneaky.class, "sneaky");
        
        blockSneakyLever = new BlockSneakyLever();
        registerBlock(blockSneakyLever, "sneaky_lever");
        
        blockSneakyGhost = new BlockSneakyGhost();
        registerBlock(blockSneakyGhost, "sneaky_ghost");
        
        blockSneakyTorch = new BlockSneakyTorch();
        registerBlock(blockSneakyTorch, "sneaky_torch");
        
        blockSneakyObsidian = new BlockSneakyObsidian();
        registerBlock(blockSneakyObsidian, "sneaky_obsidian");
        
        blockSneakyPlate = new BlockSneakyPressurePlate();
        registerBlock(blockSneakyPlate, "sneaky_plate");
        
        blockFeeder = new BlockFeeder();
        registerBlock(blockFeeder, "feeder");
        GameRegistry.registerTileEntity(TileEntityFeeder.class, "feeder");
        
        blockFakeTNT = new BlockFakeTNT();
        registerBlock(blockFakeTNT, "fake_tnt");
        
        blockShulkerPearl = new BlockShulkerPearl();
        registerBlock(blockShulkerPearl, "shulker_pearl");
        GameRegistry.registerTileEntity(TileEntityShulkerPearl.class, "shulker_pearl");
    }
    
    public static void initItems () {
        
        itemMaterial = new ItemMaterial();
        registerItem(itemMaterial, "material");
        
        itemPotion = new ItemMysteriousPotion();
        registerItem(itemPotion, "mystery_potion");
        
        itemCharmPortal = new ItemPortalCharm();
        registerItem(itemCharmPortal, "charm_portal");
    }
    
    public static void initRecipes () {
        
        final Object[] trapIngredients = new Object[] { Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE, Items.IRON_SWORD, Blocks.SOUL_SAND, Items.FLINT_AND_STEEL, new ItemStack(itemMaterial, 1, 0) };
        final Object[] filterIngredients = new Object[] { Items.GOLDEN_PICKAXE, BONE, Items.SPIDER_EYE, Items.ROTTEN_FLESH, CROP_WHEAT, Items.WATER_BUCKET, EGG, Items.MILK_BUCKET, BLOCK_SLIME };
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockEnderTether), new Object[] { " u ", "oto", 'u', new ItemStack(itemMaterial, 1, 1), 'o', OBSIDIAN, 't', Blocks.REDSTONE_TORCH, 'i', INGOT_IRON }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTrapMovement, 8), new Object[] { "isi", "bfb", 's', SLIMEBALL, 'b', STONE, 'f', Items.SUGAR }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTimer), new Object[] { "sts", "tct", "sts", 's', STONE, 't', Blocks.REDSTONE_TORCH, 'c', Items.CLOCK }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockAntiSlime), new Object[] { "sws", "wcw", "sws", 's', STONE, 'w', Blocks.COBBLESTONE_WALL, 'c', new ItemStack(itemMaterial, 1, 2) }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDetector), new Object[] { "sps", "srs", "sps", 's', STONE, 'p', Blocks.PISTON, 'r', BLOCK_REDSTONE }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSneakyBlock, 8), new Object[] { "rrr", "rsr", "rrr", 'r', STONE, 's', SLIMEBALL }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFakeTNT), new Object[] { "gwg", "wgw", "gwg", 'g', GUNPOWDER, 'w', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE) }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFeeder), new Object[] { "ccc", "geg", "ccc", 'c', new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 5), 'g', PANE_GLASS, 'e', GEM_EMERALD }));
        
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockGrate), Blocks.IRON_BARS, STONE, Blocks.TRAPDOOR));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemMaterial, 1, 1), new ItemStack(itemMaterial, 1, 0), ENDERPEARL));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemMaterial, 1, 2), new ItemStack(itemMaterial, 1, 0), SLIMEBALL));
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemMaterial, 3, 0), new ItemStack(Items.SKULL, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(blockSneakyLever), blockSneakyBlock, Blocks.LEVER);
        GameRegistry.addShapelessRecipe(new ItemStack(blockSneakyGhost), blockSneakyBlock, Blocks.WOOL);
        GameRegistry.addShapelessRecipe(new ItemStack(blockSneakyTorch), blockSneakyBlock, Blocks.TORCH);
        GameRegistry.addShapelessRecipe(new ItemStack(blockSneakyTorch), blockSneakyBlock, Blocks.REDSTONE_TORCH);
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockSneakyObsidian), blockSneakyBlock, OBSIDIAN));
        GameRegistry.addShapelessRecipe(new ItemStack(blockSneakyPlate), blockSneakyBlock, Blocks.WOODEN_PRESSURE_PLATE);
        
        addConversionRecipes(new ItemStack(blockTrapMovement), new ItemStack(blockTrapMovementFast, 1, 0));
        addConversionRecipes(new ItemStack(blockTrapMovementFast), new ItemStack(blockTrapMovementHyper, 1, 0));
        addConversionRecipes(new ItemStack(blockTrapMovementHyper), new ItemStack(blockTrapMovement, 1, 0));
        
        BookshelfRegistry.addAnvilRecipe(new ItemStack(Items.CAKE, 1), new ItemStack(Items.ENCHANTED_BOOK), "eplus", 2, new ItemStack(blockCakeEPlus));
        
        for (final BlockFilter.EnumType type : BlockFilter.EnumType.values())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFilter, 1, type.meta), new Object[] { "gsg", "sis", "gsg", 'g', "fenceGateWood", 's', STONE, 'i', filterIngredients[type.meta] }));
            
        for (final BlockTrapEffect.EnumType type : BlockTrapEffect.EnumType.values())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockTrap, 1, type.meta), new Object[] { "sis", 's', STONE, 'i', trapIngredients[type.meta] }));
    }
    
    public static void initEntities () {
        
        EntityRegistry.registerModEntity(EntityFakeTNT.class, "FakeTNT", 0, DarkUtils.instance, 32, 20, true);
    }
    
    /**
     * Adds a basic conversion recipe. A conversion recipe converts one item directly into
     * another. Adds support for converting up to 9 items a time at a 1 to 1 ratio.
     * 
     * @param input: The input item.
     * @param output: The output item.
     */
    private static void addConversionRecipes (ItemStack input, ItemStack output) {
        
        for (int amount = 1; amount < 10; amount++) {
            
            final ItemStack[] inputs = new ItemStack[amount];
            Arrays.fill(inputs, input);
            GameRegistry.addShapelessRecipe(ItemStackUtils.copyStackWithSize(output, amount), (Object[]) inputs);
        }
    }
    
    /**
     * Provides the same functionality as older forge tile registration.
     * 
     * @param block The block to register.
     * @param ID The ID to register the block with.
     */
    private static void registerBlock (Block block, String ID) {
        
        block.setRegistryName(ID);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
        BLOCKS.add(block);
    }
    
    /**
     * Provides the same functionality as older forge tile registration.
     * 
     * @param block The block to register.
     * @param ID The ID to register the block with.
     */
    private static void registerBlock (Block block, ItemBlock item, String ID) {
        
        block.setRegistryName(ID);
        GameRegistry.register(block);
        GameRegistry.register(item, block.getRegistryName());
        BLOCKS.add(block);
    }
    
    /**
     * Provides the same functionality as older forge item registration.
     * 
     * @param item The item to register.
     * @param ID The ID to register the item with.
     */
    private static void registerItem (Item item, String ID) {
        
        if (item.getRegistryName() == null)
            item.setRegistryName(ID);
            
        GameRegistry.register(item);
        ITEMS.add(item);
    }
}