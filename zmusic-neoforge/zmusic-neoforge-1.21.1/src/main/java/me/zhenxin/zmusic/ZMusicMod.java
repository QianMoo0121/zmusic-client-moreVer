package me.zhenxin.zmusic;

import me.zhenxin.zmusic.ZMusic;
import me.zhenxin.zmusic.event.NeoForgeEvent;
import me.zhenxin.zmusic.manager.SoundManagerImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;


@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Mod("zmusic")
public class ZMusicMod {

    public ZMusicMod(IEventBus modEventBus) {
        modEventBus.addListener(this::setup);
        NeoForge.EVENT_BUS.register(new NeoForgeEvent());
    }

    private void setup(FMLClientSetupEvent event) {
        ZMusic.setSoundManager(new SoundManagerImpl());
        ZMusic.onEnable();
    }
}
