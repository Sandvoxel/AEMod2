package com.Sandvoxel.appeng.AEBlocks;


import com.Sandvoxel.appeng.AEItems.AEItems;
import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

import net.minecraft.world.World;


import java.util.Random;


public class AEBaceBlock extends Block {


    public AEBaceBlock(String drive){
        super(Material.glass);
        this.setCreativeTab(AEItems.tabMyMod);
        this.setStepSound(soundTypeGlass);
    }
}
