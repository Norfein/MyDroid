package com.mydroid.game.entity;

import android.os.SystemClock;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mydroid.MyDroid;
import com.mydroid.game.Art;
import com.mydroid.game.Audio;

/**
 *
 */
public class Player extends GameObj {

    private float lastShotTime=0;
    public Player(float ix, float iy) {

        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.

    }

    @Override
    public TextureRegion getTextureRegion() {
        return Art.player;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update() {
        super.update();    //To change body of overridden methods use File | Settings | File Templates.

//        if (Gdx == Application.ApplicationType.Android)
//        {
//             a = MyDroid.getYAccel()/10; // [-10;10]
//        }
//        else

        /* Если не в состоянии равновесия */
        if (MyDroid.getYAccel()<-0.01 || MyDroid.getYAccel()>0.01)
        {
            a.x = MyDroid.getYAccel();
            //Gdx.app.log("Y accel: ", String.valueOf(MyDroid.getYAccel()));
        }
        else
        {
            a.x = 0.0f;
        }

        /* Если не в состоянии равновесия */
//        if (MyDroid.getXAccel()<-0.01 || MyDroid.getXAccel()>0.01)
//        {
//            a.y = MyDroid.getXAccel()/5;
//        }
//        else
//        {
//            a.y = 0.0f;
//        }

        /* Изменение скорости по ускорению */
        v.add(a);

        /* Сила трения */
        v.x*=0.9;
        //v.y*=0.8;

        /* Ограничение скорости */
        if (v.x>5)
            v.x = 5;
        else if (v.x<-5)
            v.x = -5;
        if (v.y>3)
            v.y = 3;
        else if (v.y<-3)
            v.y = -3;

        /* Движение */
        x += v.x;
        //y += v.y;

        /* Эффект отталкивания от границ экрана */
        if (x<0 || x>(MyDroid.getWinWidth()-getTexture().getWidth()))
            v.x *=-1.5;

        /* Управление через акслерометр */
        /* Обработка ввода */
        if (Gdx.app.getInput().isTouched())
        {
            if (SystemClock.uptimeMillis() - lastShotTime > 1000)
            {
                lastShotTime = SystemClock.uptimeMillis();
                shot();
            }
        }

        if (hp<=0)
        {
            toRemove = true;
            return;
        }

    }

    @Override
    protected void shot() {
        if (Gdx.app.getInput().getX()>MyDroid.getWinWidth()/2)
        {
            Audio.shot_gun.play();
            new RedLaser(this, new Vector2(0,-5));
        }
        else
        {
            Audio.shot_laser.play();
            new GreenLaser(this, new Vector2(0,-5));
        }
    }
}
