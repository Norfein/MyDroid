package com.mydroid.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mydroid.game.Art;

/**
 * Created by IntelliJ IDEA.
 * User: NOR00
 * Date: 14.08.11
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class GreenLaser extends Shot{
    @Override
    public TextureRegion getTextureRegion() {
        return Art.laser_green;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public GreenLaser(float ix, float iy) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public GreenLaser(GameObj go, Vector2 vec) {
        super(go, vec);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public GreenLaser(float ix, float iy, Vector2 vec) {
        super(ix, iy, vec);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
