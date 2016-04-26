package com.Sandvoxel.appeng.AEBlocks;

import com.Sandvoxel.appeng.tileEntiy.AETileEntiy;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;


public class cabels extends Block implements ITileEntityProvider {

    public static final PropertyEnum NORTH = PropertyEnum.<cabels.EnumAttachPosition>create("north", cabels.EnumAttachPosition.class);
    public static final PropertyEnum EAST = PropertyEnum.<cabels.EnumAttachPosition>create("east", cabels.EnumAttachPosition.class);
    public static final PropertyEnum SOUTH = PropertyEnum.<cabels.EnumAttachPosition>create("south", cabels.EnumAttachPosition.class);
    public static final PropertyEnum WEST = PropertyEnum.<cabels.EnumAttachPosition>create("west", cabels.EnumAttachPosition.class);
    public static final PropertyEnum UP = PropertyEnum.<cabels.EnumAttachPosition>create("up", cabels.EnumAttachPosition.class);
    public static final PropertyEnum DOWN = PropertyEnum.<cabels.EnumAttachPosition>create("down", cabels.EnumAttachPosition.class);


    public cabels (String drive){
        super(Material.glass);
        this.setUnlocalizedName("cable");
        this.setStepSound(soundTypeGlass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, cabels.EnumAttachPosition.NONE).withProperty(EAST, cabels.EnumAttachPosition.NONE).withProperty(SOUTH, cabels.EnumAttachPosition.NONE).withProperty(WEST, cabels.EnumAttachPosition.NONE).withProperty(UP, cabels.EnumAttachPosition.NONE).withProperty(DOWN, cabels.EnumAttachPosition.NONE));


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

    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        return block == AEBlocks.cabel ? true : block == AEBlocks.drive ? true : false;
    }

    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        boolean flagNorth = this.canConnectTo(worldIn, pos.north());
        boolean flagSouth = this.canConnectTo(worldIn, pos.south());
        boolean flagWest = this.canConnectTo(worldIn, pos.west());
        boolean flagEast = this.canConnectTo(worldIn, pos.east());
        boolean flagUp = this.canConnectTo(worldIn, pos.up());
        boolean flagDown = this.canConnectTo(worldIn, pos.down());


        this.setBlockBounds(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        this.setBlockBounds(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
    }






    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        state = state.withProperty(WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
        state = state.withProperty(EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
        state = state.withProperty(NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
        state = state.withProperty(SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
        state = state.withProperty(UP, this.getAttachPosition(worldIn, pos, EnumFacing.UP));
        state = state.withProperty(DOWN, this.getAttachPosition(worldIn, pos, EnumFacing.DOWN));

        return state;
    }
    private cabels.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos blockpos = pos.offset(direction);
        Block block = worldIn.getBlockState(pos.offset(direction)).getBlock();

        if (!canCableConnect(worldIn, blockpos, direction) && (block.isNormalCube() || !canCableConnect(worldIn, blockpos, direction)))
        {
            return EnumAttachPosition.SIDE;
        }
        else
        {
            return EnumAttachPosition.NONE;
        }
    }
    protected static boolean canCableConnect(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == AEBlocks.cabel || state.getBlock() == AEBlocks.drive)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] { NORTH, EAST, WEST, SOUTH, UP, DOWN});
    }


    enum EnumAttachPosition implements IStringSerializable
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
        return getDefaultState().withProperty(SOUTH, meta == 0 ? EnumAttachPosition.NONE : EnumAttachPosition.SIDE );
    }


    @Override
    public int getMetaFromState(IBlockState state) {
        EnumAttachPosition type = (EnumAttachPosition) state.getValue(SOUTH);
        return type.getID();
    }
    }






