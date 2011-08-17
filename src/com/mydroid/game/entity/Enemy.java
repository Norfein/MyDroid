package com.mydroid.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mydroid.game.Art;

/**
 *
 */
public class Enemy extends GameObj {
    private static String textureCode = "enemy64.png";
    public Enemy(float ix, float iy) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public TextureRegion getTextureRegion() {
        return Art.enemy;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update() {
        super.update();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
