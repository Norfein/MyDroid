package com.mydroid;

import android.os.SystemClock;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mydroid.game.Art;
import com.mydroid.game.Audio;
import com.mydroid.game.entity.GameObj;
import com.mydroid.game.entity.Player;
import com.mydroid.game.manage.SoundManager;
import com.mydroid.game.manage.TextureManager;
import com.mydroid.game.screen.Screen;
import com.mydroid.game.screen.ScreenGame;

import javax.microedition.khronos.opengles.GL10;

/**
 * Игровое приложение
 */
public class MyDroid implements ApplicationListener{

    public static int getWinWidth(){return Gdx.app.getGraphics().getWidth();}
    public static int getWinHeight(){return Gdx.app.getGraphics().getHeight();}

    /* Текущее положение акселероментра по Y (ось снизу вверх) [-10;10]*/
    public static float getYAccel(){
        return Gdx.input.getAccelerometerY();
    }
    public static float getXAccel(){
        return Gdx.input.getAccelerometerX();
    }
    public static float getZAccel(){
        return Gdx.input.getAccelerometerZ();
    }

    /* Текущий скрин*/
    private Screen screen;

    public MyDroid() {
    }

    /* Установка текущего скрина */
    public void setScreen(Screen newScreen) {
            if (screen != null)
                    screen.removed();
            screen = newScreen;
            if (screen != null)
                    screen.init(this);
    }

    /* Создание приложения */
    public void create() {
        Art.load();
        Audio.load();

        setScreen(new ScreenGame());
        Gdx.gl.glClearColor(0, 0, 0, 1);
    }

    private float lastUpd = 0.0f;

    /* Рендеринг текущего скрина */
    public void render() {

        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        if (SystemClock.uptimeMillis() - lastUpd > 10.0f)
        {
            lastUpd = SystemClock.uptimeMillis();
            screen.update();
        }

        screen.render();
    }

    /* При паузе */
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates
        GdxNotifyLog("pause!");
    }

    /* Восстановление после перерыва */
    public void resume() {
        GdxNotifyLog("resume!");
    }

    /* При изменении окна */
    public void resize(int i, int i1) {
        //To change body of implemented methods use File | Settings | File Templates.
        GdxNotifyLog("resize!");
    }

    /* При завершении */
    public void dispose() {
        //GameObj.getObjectList().clear();
        GdxNotifyLog("dispose!");
    }


    private static void GdxLog(String title, String body)
    {
        Gdx.app.log(title, body);
    }
    private static void GdxNotifyLog(String body)
    {
        Gdx.app.log("Notification", body);
    }
    private static void GdxErrorLog(String body)
    {
        Gdx.app.log("Error", body);
    }
}
