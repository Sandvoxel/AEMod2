package com.Sandvoxel.appeng.tileEntiy;

import com.Sandvoxel.appeng.AESaveData.AEDriveCache;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 4/25/2016.
 */
public class AEDriveEntiy extends TileEntity {

    private List<AEDriveCache> data = new ArrayList<AEDriveCache>();

    public void adddata ( ItemStack dart){
        NBTTagCompound nbt = (NBTTagCompound) dart.getTagCompound().getTag("bool");
        boolean test = nbt.getBoolean("test");
        data.add(new AEDriveCache(test));
    }




}

