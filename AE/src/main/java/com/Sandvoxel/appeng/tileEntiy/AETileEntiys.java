package com.Sandvoxel.appeng.tileEntiy;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by koval on 4/24/2016.
 */
public class AETileEntiys {

    public static void init() {
        GameRegistry.registerTileEntity(AETileEntiy.class, "tile_entity");
    }

}
