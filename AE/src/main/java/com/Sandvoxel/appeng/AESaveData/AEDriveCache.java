package com.Sandvoxel.appeng.AESaveData;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by koval on 4/25/2016.
 */
public class AEDriveCache {
    private static Boolean test;

    public AEDriveCache(boolean test) {
        this.test = test;
    }

    public static boolean readTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void writeEntryToNBT(NBTTagCompound nbt)
    {

        nbt.setBoolean("test", test);
    }
    public static AEDriveCache readEntryFromNBT(NBTTagCompound nbt)
    {
        return new AEDriveCache(nbt.getBoolean("test"));
    }

}
