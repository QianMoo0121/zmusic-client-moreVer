package me.zhenxin.zmusic.event;

import me.zhenxin.zmusic.ZMusic;
import net.minecraft.sounds.SoundSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.sound.SoundEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;


public class NeoForgeEvent {

    @SubscribeEvent
    public void onSound(final SoundEvent.SoundSourceEvent e) {
        if (!ZMusic.getPlayer().isPlay()) {
            return;
        }
        SoundSource data = e.getSound().getSource();

        switch (data) {
            case MUSIC:
            case RECORDS:
                e.getChannel().stop();
                break;
            default:
        }
    }

    @SubscribeEvent
    public void onServerQuit(final ClientPlayerNetworkEvent.LoggingOut e) {
        try {
            ZMusic.getPlayer().closePlayer();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onTick(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide) {
            ZMusic.getPlayer().tick();
        }
    }
}
