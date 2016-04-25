package com.Sandvoxel.appeng.AEItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by koval on 4/25/2016.
 */
public class Drives extends Item {

    public Drives(String onekdrive){
        super();

        this.setCreativeTab(AEItems.tabMyMod);
        this.setUnlocalizedName("onekdrive");


    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {

        return false;
    }
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (playerIn.isSneaking()){
            if (stack.getTagCompound() == null){
                System.out.println("this works");
            }
        }
        return stack;
    }

}
