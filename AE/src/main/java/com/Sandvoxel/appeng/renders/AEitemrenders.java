package com.Sandvoxel.appeng.renders;

import com.Sandvoxel.appeng.data;
import com.Sandvoxel.appeng.AEItems.AEItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;


public class AEitemrenders {
    public static String modid = data.MODID;

    public static void registerItemRenderer() {
        reg(AEItems.test);
    }

    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }


}
