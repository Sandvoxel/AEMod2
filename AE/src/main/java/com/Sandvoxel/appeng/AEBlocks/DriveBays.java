package com.Sandvoxel.appeng.AEBlocks;

import com.Sandvoxel.appeng.AEItems.Drives;
import com.Sandvoxel.appeng.AESaveData.AEDriveCache;
import com.Sandvoxel.appeng.tileEntiy.AEDriveEntiy;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

/**
 * Created by koval on 4/26/2016.
 */
public class DriveBays extends Faceing implements ITileEntityProvider {

    public DriveBays (String drive){
        super(drive);
        setUnlocalizedName("drive");


    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = playerIn.getCurrentEquippedItem();
        if(stack != null)
        {
            if(stack.getItem() instanceof Drives)
            {
                if (stack.hasTagCompound()){
                    NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("bool");
                    boolean testse = nbt.getBoolean("test");

                    AEDriveCache tests = AEDriveCache.readEntryFromNBT(nbt);

                    AEDriveEntiy tect = (AEDriveEntiy) worldIn.getTileEntity(pos);
                    stack.stackSize--;
                    playerIn.addChatMessage(new ChatComponentText("Added cordinate cache to tile entity " + testse ));
                    playerIn.addChatMessage(new ChatComponentText(" this is a thing "+ tests));

                }

            }
        }
        return true;
    }


    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AEDriveEntiy();
    }




}
