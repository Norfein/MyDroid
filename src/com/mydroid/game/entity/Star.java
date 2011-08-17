package com.mydroid.game.entity;

import android.widget.TabHost;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mydroid.MyDroid;
import com.mydroid.game.Art;

import java.util.Random;

/**
 *
 */
public class Star extends GameObj{

    @Override
    public TextureRegion getTextureRegion() {
        return Art.star;  //To change body of implemented methods use File | Settings | File Templates.
    }

    Random r;
    public Star(float ix, float iy) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
        isConst = true;
        /* Звёздочки не учавствуют в проверках на столкновение */
        r = new Random();
        if (ix==-1)
            this.x = r.nextFloat()*(MyDroid.getWinWidth() - getTexture().getWidth());
        if (iy==-1)
            this.y = r.nextFloat()*(MyDroid.getWinHeight() - getTexture().getHeight());

    }

    /* Рандомный конструктор */
    public Star() {
        super(0, 0);    //To change body of overridden methods use File | Settings | File Templates.
        isConst = true;
        /* Звёздочки не учавствуют в проверках на столкновение */
        r = new Random();
        /* Рандомизация положения и скорости */
        this.x = r.nextFloat()*(MyDroid.getWinWidth() - getTexture().getWidth());
        this.y = r.nextFloat()*(MyDroid.getWinHeight() - getTexture().getHeight());

        // [ Скорость [1..10]
        this.v.y = 1+r.nextFloat()*9;
        /* Установка зависимости размера звёздочки от её скорости. Чем меньше, тем медленнее */
        this.size = v.y/10;
    }

    public Star(float ix, float iy, Vector2 vec) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.

        /* Звёздочки не учавствуют в проверках на столкновение */
        isConst = true;
        v = vec;
    }

    @Override
    public void update() {
        super.update();    //To change body of overridden methods use File | Settings | File Templates.
        x+= v.x;
        y+= v.y;

        /* Если улетела за экран */
        if (y>MyDroid.getWinHeight())
        {
            /* Перемещаем на начало */
            y = -getTexture().getHeight();
            /* Раздомим x */
            x = r.nextFloat()*(MyDroid.getWinWidth() - getTexture().getWidth());
        }
    }
}
