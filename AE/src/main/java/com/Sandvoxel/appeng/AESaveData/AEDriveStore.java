package com.Sandvoxel.appeng.AESaveData;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

/**
 * Created by koval on 4/25/2016.
 */
public class AEDriveStore {
    private Boolean test;

    public AEDriveStore(boolean test) {
        this.test = test;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void writeEntryToNBT(NBTTagCompound nbt)
    {

        nbt.setBoolean("test", test);
    }
    public static AEDriveStore readEntryFromNBT(NBTTagCompound nbt)
    {
        return new AEDriveStore(nbt.getBoolean("test"));
    }

}
