package com.mydroid.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mydroid.game.Art;

/**
 * Created by IntelliJ IDEA.
 * User: NOR00
 * Date: 14.08.11
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class Explosion extends GameObj{

    @Override
    public TextureRegion getTextureRegion() {
        return Art.explosion;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Explosion(float ix, float iy) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
