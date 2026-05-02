package net.vercte.skylogged.pack;

import com.simibubi.create.foundation.pack.DynamicPack;
import com.simibubi.create.foundation.pack.DynamicPackSource;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;

public class SkyloggedDynamicPack extends DynamicPack {
    private static final String PACK_ID = "skylogged:dynamic_data";

    public SkyloggedDynamicPack(PackType packType) {
        super(PACK_ID, packType);
    }

    public DynamicPackSource getDynamicSource() {
        return new DynamicPackSource(PACK_ID, PackType.SERVER_DATA, Pack.Position.TOP, this);
    }

    public void populate() {

    }
}
