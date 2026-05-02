package net.vercte.skylogged;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.vercte.skylogged.pack.SkyloggedDynamicPack;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Skylogged.ID)
public class Skylogged {
    public static final String ID = "skylogged";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Skylogged(IEventBus modEventBus) {
        LOGGER.info("I feel so skylogged!");
//        modEventBus.addListener(this::addPackFinders);
    }

    private void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.SERVER_DATA) return;
        SkyloggedDynamicPack pack = new SkyloggedDynamicPack(PackType.SERVER_DATA);
        pack.populate();

        event.addRepositorySource(pack.getDynamicSource());
    }

    public static ResourceLocation at(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
