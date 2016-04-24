package com.Sandvoxel.appeng.AEItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AEItems {


    public static final CreativeTabs tabMyMod = new CreativeTabs("myMod") {
        @Override
        public Item getTabIconItem() {
            return AEItems.test;
        }
    };

    public static Item test;





    public static void createitems() {
        GameRegistry.registerItem(test = new palceitem("test"), test.getUnlocalizedName().substring(5));
    }
}
