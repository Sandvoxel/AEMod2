package com.Sandvoxel.appeng.AEBlocks;

import com.Sandvoxel.appeng.AEItems.AEItems;
import com.Sandvoxel.appeng.data;
import com.Sandvoxel.appeng.tileEntiy.AETileEntiy;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;
import java.util.Set;


public class cabels extends Block implements ITileEntityProvider {

    public static final PropertyEnum NORTH = PropertyEnum.<cabels.EnumAttachPosition>create("north", cabels.EnumAttachPosition.class);
    public static final PropertyEnum EAST = PropertyEnum.<cabels.EnumAttachPosition>create("east", cabels.EnumAttachPosition.class);
    public static final PropertyEnum SOUTH = PropertyEnum.<cabels.EnumAttachPosition>create("south", cabels.EnumAttachPosition.class);
    public static final PropertyEnum WEST = PropertyEnum.<cabels.EnumAttachPosition>create("west", cabels.EnumAttachPosition.class);
    //public static final PropertyEnum UP = PropertyEnum.<cabels.EnumAttachPosition>create("up", cabels.EnumAttachPosition.class);
    //public static final PropertyEnum DOWN = PropertyEnum.<cabels.EnumAttachPosition>create("down", cabels.EnumAttachPosition.class);


    public cabels (String drive){
        super(Material.glass);
        this.setUnlocalizedName("cable");

        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, cabels.EnumAttachPosition.NONE).withProperty(EAST, cabels.EnumAttachPosition.NONE).withProperty(SOUTH, cabels.EnumAttachPosition.NONE).withProperty(WEST, cabels.EnumAttachPosition.NONE));


         }
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AETileEntiy();
    }





    public int quantityDropped(Random random)
    {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        this.setBlockBounds(0.55F, 0.62F, 0.45F, 0.45F, 0.3F, 0.55F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        this.setBlockBounds(0.38F, 0.38F, 0.38F, 0.627F, 0.627F, 0.627F);
    }






    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        state = state.withProperty(WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
        state = state.withProperty(EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
        state = state.withProperty(NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
        state = state.withProperty(SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
        //state = state.withProperty(UP, this.getAttachPosition(worldIn, pos, EnumFacing.UP));

        return state;
    }
    private cabels.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos blockpos = pos.offset(direction);
        Block block = worldIn.getBlockState(pos.offset(direction)).getBlock();

        if (!canRestoneConnect(worldIn, blockpos, direction) && (block.isNormalCube() || !canRestoneConnect(worldIn, blockpos.down(), null)))
        {
            Block block1 = worldIn.getBlockState(pos.up()).getBlock();
            return EnumAttachPosition.SIDE;
        }
        else
        {
            return EnumAttachPosition.NONE;
        }
    }
    protected static boolean canRestoneConnect(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == AEBlocks.cabel)
        {
            return true;
        }
        else
        {
            return state.getBlock() == AEBlocks.drive;

        }
    }















    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { NORTH, EAST, WEST, SOUTH,});
    }


    static enum EnumAttachPosition implements IStringSerializable
    {

        NONE(0, "side"),
        SIDE(1 ,"none");


        private final String name;
        private final int ID;

        private EnumAttachPosition(int ID ,String name)
        {
            this.name = name;
            this.ID = ID;
        }

        public String toString()
        {
            return this.getName();
        }
        @Override
        public String getName()
        {
            return this.name;
        }
        public int getID() {
            return ID;
        }

    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty( SOUTH, meta == 0 ? EnumAttachPosition.NONE : EnumAttachPosition.SIDE );
    }


    @Override
    public int getMetaFromState(IBlockState state) {
        EnumAttachPosition type = (EnumAttachPosition) state.getValue(SOUTH);
        return type.getID();
    }
    }






