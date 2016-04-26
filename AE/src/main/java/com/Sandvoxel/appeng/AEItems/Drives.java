package com.Sandvoxel.appeng.AEItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by koval on 4/25/2016.
 */
public class Drives extends Item {

    public Drives(String unlocalizedName){
        super();

        this.setCreativeTab(AEItems.tabMyMod);
        this.setUnlocalizedName(unlocalizedName);


    }
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (playerIn.isSneaking()){
            if (stack.getTagCompound() == null){

                stack.setTagCompound(new NBTTagCompound());
            }
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setBoolean("test",true);
            stack.getTagCompound().setTag("bool", nbt);
            stack.setStackDisplayName(EnumChatFormatting.DARK_GRAY + "Drive");
        }
        return false;
    }
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        NBTTagCompound nbt = stack.getTagCompound();

        if (!playerIn.isSneaking()){
            if (stack.getTagCompound() != null){

                System.out.println("this works");
                nbt.setBoolean("test", false);
                stack.clearCustomName();
            }
        }
        return stack;
    }
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        if (stack.hasTagCompound()) {
            tooltip.add("NBT: " + stack.getTagCompound().toString());
        } else {
            tooltip.add("No NBT data stored");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(stack.getTagCompound() != null)
        {
            return stack.getTagCompound().hasKey("bool");
        }
        return false;
    }
}
