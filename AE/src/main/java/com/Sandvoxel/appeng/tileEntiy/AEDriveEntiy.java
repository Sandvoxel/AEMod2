package com.Sandvoxel.appeng.tileEntiy;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 4/25/2016.
 */
public class AEDriveEntiy extends TileEntity {

    private List<Boolean> data = new ArrayList<Boolean>();

    public void adddata ( ItemStack dart){
        NBTTagCompound nbt = (NBTTagCompound) dart.getTagCompound().getTag("bool");
        boolean test = nbt.getBoolean("test");
    }


    @Override
    public void writeToNBT(NBTTagCompound compound){
    super.writeToNBT(compound);





}
}
