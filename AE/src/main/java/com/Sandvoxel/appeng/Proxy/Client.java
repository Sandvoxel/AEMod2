package com.Sandvoxel.appeng.Proxy;

import com.Sandvoxel.appeng.renders.AEitemrenders;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by koval on 4/22/2016.
 */
public class Client extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        AEitemrenders.registerItemRenderer();
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

}
