package com.Sandvoxel.appeng.Proxy;

import com.Sandvoxel.appeng.AEBlocks.AEBlocks;
import com.Sandvoxel.appeng.AEItems.AEItems;

import com.Sandvoxel.appeng.main;
import com.Sandvoxel.appeng.tileEntiy.AETileEntiys;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        AEItems.createitems();
        AEBlocks.createblocks();
        AETileEntiys.init();

    }
    public void init(FMLInitializationEvent e) {

    }


    public void postInit(FMLPostInitializationEvent e) {

    }


}
