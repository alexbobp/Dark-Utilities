package net.darkhax.darkutils.features.dyeslime;

import net.darkhax.bookshelf.item.ItemBlockBasic;
import net.darkhax.bookshelf.util.OreDictUtils;
import net.darkhax.darkutils.DarkUtils;
import net.darkhax.darkutils.features.DUFeature;
import net.darkhax.darkutils.features.Feature;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@DUFeature(name = "Dyed Slime Blocks", description = "Colorful slime blocks!")
public class FeatureDyeSlime extends Feature {

    private static String[] COLORS = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black" };

    public static Block blockSlime;

    @Override
    public void onPreInit () {

        blockSlime = new BlockSlimeDyed();
        DarkUtils.REGISTRY.registerBlock(blockSlime, new ItemBlockBasic(blockSlime, COLORS, false), "slime_dyed");
    }

    @Override
    public void onPreRecipe () {

        for (final EnumDyeColor dye : EnumDyeColor.values()) {

            DarkUtils.REGISTRY.addShapedRecipe("dyed_slime_block_" + dye.getName(), new ItemStack(blockSlime, 8, dye.getMetadata()), "sss", "sds", "sss", 's', OreDictUtils.BLOCK_SLIME, 'd', new ItemStack(Items.DYE, 1, dye.getDyeDamage()));
        }
    }

    @Override
    public void onInit () {

        for (final EnumDyeColor color : EnumDyeColor.values()) {
            OreDictionary.registerOre(OreDictUtils.BLOCK_SLIME, new ItemStack(blockSlime, 1, color.getMetadata()));
        }
    }
}
