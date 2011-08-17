package com.mydroid.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mydroid.MyDroid;
import com.mydroid.game.Audio;
import com.mydroid.game.entity.GameObj;
import com.mydroid.game.entity.Player;
import com.mydroid.game.entity.RedLaser;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: e_krais
 * Date: 15.08.11
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class ScreenGame extends Screen{

    Player player;
    public ScreenGame()
    {
        super();
        player = new Player(MyDroid.getWinWidth()/2, MyDroid.getWinHeight()-64);
        Audio.msc_cell.setLooping(true);
        Audio.msc_cell.play();
    }
    @Override
    public void removed() {
        super.removed();    //To change body of overridden methods use File | Settings | File Templates.
        Audio.msc_cell.stop();
        GameObj.clearObjectList();
    }

    @Override
    public void update() {
        /* Итерируем все игровые объекты. Удаляем, если помечен на удаление, иначе апдейт */

        GameObj.syncObjCollection();

        for (Iterator<GameObj> iter = GameObj.ObjectList.iterator(); iter.hasNext();)
        {
            GameObj go = iter.next();
            if (go.ToRemove())
            {
                go.remove();
                iter.remove();
            }
            else
            {
                go.update();
            }
        }

        //tmr();
    }

    private void tmr()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.F1))
        {
            spriteBatch.getProjectionMatrix().setToOrtho(0, MyDroid.getWinWidth(), MyDroid.getWinHeight(), 0, 0, 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.F2))
        {
            spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, MyDroid.getWinWidth(), MyDroid.getWinHeight());
        }
    }

    @Override
    public void render() {
        spriteBatch.begin();
        /* Получаем неизменяемый список */
        for (GameObj go: GameObj.ObjectList)
        {
            if (!go.ToRemove())
            {
                draw(go, go.x, go.y);
            }
        }
        spriteBatch.end();
    }
}
