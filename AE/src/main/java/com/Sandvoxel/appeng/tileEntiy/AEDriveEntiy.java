package com.Sandvoxel.appeng.tileEntiy;

import com.Sandvoxel.appeng.AESaveData.AEDriveStore;
import net.minecraft.client.renderer.texture.ITickable;
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

    private List<AEDriveStore> data = new ArrayList<AEDriveStore>();

    public void adddata ( ItemStack dart){
        NBTTagCompound nbt = (NBTTagCompound) dart.getTagCompound().getTag("bool");
        boolean test = nbt.getBoolean("test");
        data.add(new AEDriveStore(test));
    }
    public AEDriveStore getEntry(int i)
    {
        if(i < data.size())
        {
            return data.get(i);
        }
        return null;
    }
    public void deleteEntry(int i)
    {
        if(i < data.size())
        {
            data.remove(i);
        }
    }
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        data = new ArrayList<AEDriveStore>();

        NBTTagList entryList = (NBTTagList) compound.getTag("teleports");
        for(int i = 0; i < entryList.tagCount(); i++)
        {
            NBTTagCompound entryCompound = entryList.getCompoundTagAt(i);
            AEDriveStore entry = AEDriveStore.readEntryFromNBT(entryCompound);
            data.add(entry);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        NBTTagList entryList = new NBTTagList();
        for(AEDriveStore entry : data)
        {
            NBTTagCompound entryCompound = new NBTTagCompound();
            entry.writeEntryToNBT(entryCompound);
            entryList.appendTag(entryCompound);
        }

        compound.setTag("teleports", entryList);
    }



}

