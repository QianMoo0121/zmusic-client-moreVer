package me.zhenxin.zmusic.manager;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;


public class SoundManagerImpl implements SoundManager {

    @Override
    public float volume() {
        return Minecraft.getInstance().options.getSoundSourceVolume(SoundSource.RECORDS);
    }

    @Override
    public void stop() {
        Minecraft.getInstance().getSoundManager().stop(null, SoundSource.MUSIC);
        Minecraft.getInstance().getSoundManager().stop(null, SoundSource.RECORDS);
    }
}
