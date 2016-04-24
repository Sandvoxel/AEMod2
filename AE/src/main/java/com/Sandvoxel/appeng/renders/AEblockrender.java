package com.Sandvoxel.appeng.renders;

import com.Sandvoxel.appeng.AEBlocks.AEBlocks;
import com.Sandvoxel.appeng.data;
import com.Sandvoxel.appeng.tileEntiy.AETileEntiy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class AEblockrender {
    public static String modid = data.MODID;

    public static void registerItemRenderer() {
        reg(AEBlocks.drive);
        reg(AEBlocks.cabel);
    }

 public static void reg(Block block){

     Item item = Item.getItemFromBlock(block);
     Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));

 }
}
