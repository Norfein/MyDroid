package com.mydroid.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Класс, хранящий графику
 */
public class Art {

    private static String dir = "gfx/";
    /* FIELDS */
    /* Используем TextureRegion, тк можно просто флипать */
    public static TextureRegion player;
    public static TextureRegion enemy;
    public static TextureRegion laser_red;
    public static TextureRegion laser_green;
    public static TextureRegion asteroid;
    public static TextureRegion star;
    public static TextureRegion explosion;

    /* STATIC METHODS */
    public static void load()
    {
        asteroid = get("asteroid64.png");
        enemy = get("enemy64.png");
        explosion = get("explosion64.png");
        laser_green = get("laser_green32.png");
        laser_red = get("laser_red32.png");
        player = get("player64.png");
        star = get("star32.png");
    }

    public static TextureRegion get(String fname)
    {
        TextureRegion tr = new TextureRegion(new Texture(Gdx.files.internal(dir+fname)));
        tr.flip(false, true);
        return tr;
    }

}
