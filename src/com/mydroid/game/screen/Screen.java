package com.mydroid.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.mydroid.MyDroid;

import com.badlogic.gdx.graphics.Camera;
import com.mydroid.game.entity.GameObj;

import java.util.logging.XMLFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: e_krais
 * Date: 15.08.11
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class Screen {
    public SpriteBatch spriteBatch;
    private MyDroid main;

    public final void init(MyDroid myDroid)
    {
        /* Базовая настройка */
        this.main = myDroid;
        spriteBatch = new SpriteBatch();
        /* Инвертируем Y */
        spriteBatch.getProjectionMatrix().setToOrtho(0, MyDroid.getWinWidth(), MyDroid.getWinHeight(), 0, 0, 1);
    }

    protected void setScreen(Screen tarScreen)
    {
        main.setScreen(tarScreen);
    }

    public void draw(Texture texture, float tx, float ty)
    {
        spriteBatch.draw(texture, tx, ty, texture.getWidth(), texture.getHeight());
        //spriteBatch.draw(texture, tx, ty, texture.getWidth(), texture.getHeight(), (int)tx, (int)ty, texture.getWidth(), texture.getHeight(), false, true);
    }
    public void draw(TextureRegion tr, float tx, float ty)
    {
        spriteBatch.draw(tr, tx, ty);
        //spriteBatch.draw(texture, tx, ty, texture.getWidth(), texture.getHeight(), (int)tx, (int)ty, texture.getWidth(), texture.getHeight(), false, true);
    }

    public void draw(GameObj go, float tx, float ty)
    {
        spriteBatch.draw(go.getTextureRegion(), tx, ty);
        //spriteBatch.draw(texture, tx, ty, texture.getWidth(), texture.getHeight(), (int)tx, (int)ty, texture.getWidth(), texture.getHeight(), false, true);
    }

    public void removed()
    {
        spriteBatch.dispose();
    }

    public void update() {

    }

    public abstract void render();
}