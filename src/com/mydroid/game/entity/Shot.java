package com.mydroid.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.Collections;
import java.util.Iterator;

/**
 *
 */
public abstract class Shot extends GameObj {

    public boolean isPlayerShot = false;
    private int damage = 10;

    public Shot(float ix, float iy) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
    }

    /* Указывается направление выстрела*/
    public Shot(float ix, float iy, Vector2 vec) {
        super(ix, iy);    //To change body of overridden methods use File | Settings | File Templates.
        v = vec;
    }

    /* Указывается направление выстрела*/
    public Shot(GameObj go) {
        super(go.x, go.y);    //To change body of overridden methods use File | Settings | File Templates.
        isPlayerShot = go instanceof Player;
    }

    /* Указывается направление выстрела*/
    public Shot(GameObj go, Vector2 vec) {
        super(go.centX(), go.centY());    //To change body of overridden methods use File | Settings | File Templates.
        v = vec;
        //isPlayerShot = go instanceof Player;

        Gdx.app.log("=== notify === ","shot create");
    }

    @Override
    public void update() {
        super.update();    //To change body of overridden methods use File | Settings | File Templates.

        x += v.x;
        y += v.y;

        if (y<0)
        {
            toRemove = true;
        }
//
//        /* Проверка попадания */
//        for (GameObj go: Collections.unmodifiableList(GameObj.getObjectList()))
//        {
//             if (this.equals(go))
//                continue;
//            /* Если пульнул игрок и текущий объект - игрок или
//            *  Если пульнули враги и текущий враги, пропустить проверку */
//            if (isPlayerShot & (go instanceof Player))
//                    continue;
//            if (hitZone.overlaps(go.hitZone))
//            {
//                go.hp -= damage;
//            }
//        }
//        for (Iterator<GameObj> iter = GameObj.getObjectList().iterator(); iter.hasNext();)
//        {
//            GameObj go = iter.next();
//            if (this.equals(go))
//                continue;
//            /* Если пульнул игрок и текущий объект - игрок или
//            *  Если пульнули враги и текущий враги, пропустить проверку */
//            if (isPlayerShot & (go instanceof Player))
//                    continue;
//            if (hitZone.overlaps(go.hitZone))
//            {
//                go.hp -= damage;
//            }
//        }
    }
}
