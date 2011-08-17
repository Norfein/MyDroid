package com.mydroid.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: e_krais
 * Date: 15.08.11
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class Audio {

    /* FIELDS */
    private static String soundDir = "sound/";
    private static String musicDir = "music/";
    public static Sound shot_laser;
    public static Sound shot_gun;

    public static Music msc_cell;

    /* STATIC METHODS */
    public static void load()
    {
        shot_gun = getSound("shot.ogg");
        shot_laser = getSound("shot2.ogg");

        msc_cell = getMusic("cell.mp3");
    }

    private static Sound getSound(String fname)
    {
        return Gdx.audio.newSound(Gdx.files.internal(soundDir+fname));
    }

    private static Music getMusic(String fname)
    {
        return Gdx.audio.newMusic(Gdx.files.internal(musicDir+fname));
    }
}
