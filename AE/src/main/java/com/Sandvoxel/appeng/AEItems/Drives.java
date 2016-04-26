package com.Sandvoxel.appeng.AEItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public Drives(String onekdrive){
        super();

        this.setCreativeTab(AEItems.tabMyMod);
        this.setUnlocalizedName("onekdrive");


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
            stack.setStackDisplayName(EnumChatFormatting.BLACK + "Drive");
        }
        return false;
    }
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.isSneaking()){
            if (stack.getTagCompound() != null){
                System.out.println("this works");
                stack.getTagCompound().removeTag("bool");
                stack.clearCustomName();
            }
        }
        return stack;
    }
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        if (stack.getTagCompound().hasKey("bool")){

        }
        NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("bool");
        boolean test = nbt.getBoolean("test");
        tooltip.add("state "+ test);


    }
}
