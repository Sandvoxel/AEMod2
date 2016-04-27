package com.Sandvoxel.appeng.AEItems;

import com.Sandvoxel.appeng.AEBlocks.AEBlocks;
import com.Sandvoxel.appeng.AESaveData.AEDriveCache;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by koval on 4/23/2016.
 */
public class palceitem extends AEBaceitems {


    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn){

        if (stack.getTagCompound() != null) {
            boolean test = AEDriveCache.readTest();
            System.out.print(test);
        }


        return stack;

    }


    public palceitem(String test) {
        super(test);
    }
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
        BlockPos blockpos = flag ? pos : pos.offset(side);

        if (!playerIn.canPlayerEdit(blockpos, side, stack))
        {
            return false;
        }
        else
        {
            Block block = worldIn.getBlockState(blockpos).getBlock();

            if (!worldIn.canBlockBePlaced(block, blockpos, false, side, (Entity)null, stack))
            {
                return false;
            }
            else if (AEBlocks.cabel.canPlaceBlockAt(worldIn, blockpos))
            {
                --stack.stackSize;
                worldIn.setBlockState(blockpos, AEBlocks.cabel.getDefaultState());
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}