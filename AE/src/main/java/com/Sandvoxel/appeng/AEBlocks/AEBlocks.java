package com.Sandvoxel.appeng.AEBlocks;


import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class AEBlocks {

    public static Block drive;
    public static Block cabel;


    public static void createblocks(){
        GameRegistry.registerBlock(drive= new Faceing("drive"), drive.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(cabel= new cabels("cabel"), cabel.getUnlocalizedName().substring(5));
    }
}
