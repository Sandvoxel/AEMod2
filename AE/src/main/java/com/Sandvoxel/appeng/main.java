package com.Sandvoxel.appeng;


import com.Sandvoxel.appeng.Proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class main {


@Mod.Instance
public static main.MorePowerMain instance = new main.MorePowerMain();



    @Mod(modid = data.MODID, version = data.VERSION,name = data.NAME)
    public static class MorePowerMain {

        @SidedProxy(clientSide = data.Client,serverSide = data.Server)
        public static CommonProxy proxy;





        @Mod.EventHandler
        public void PreInit(FMLPreInitializationEvent event){
            proxy.preInit(event);
        }


        @Mod.EventHandler
        public void init(FMLInitializationEvent event){
            proxy.init(event);
        }

        @Mod.EventHandler
        public void PostInit(FMLPostInitializationEvent event){
            proxy.postInit(event);
        }


    }}
