package com.mydroid.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mydroid.game.tools.ReflectionUtils;

import java.io.ObjectInputStream;
import java.util.*;

/**
 *
 */
public abstract class GameObj {

    /* ====== STATIC ====== */
    public static ArrayList<GameObj> ObjectList = new ArrayList<GameObj>();

    // Очередь объектов на добавление в коллекцию.
    private static ArrayList<GameObj> ObjectBuffer = new ArrayList<GameObj>();

    /* Добавляет объект в буффер */
    public static GameObj AddToObjectList(GameObj gobj)
    {
        ObjectBuffer.add(gobj);
        return gobj;
    }

    /* Копируем объекты из ObjectBuffer в ObjectList */
    public static void syncObjCollection()
    {
        if (ObjectBuffer.isEmpty())
            return;
        ObjectList.addAll(ObjectBuffer);
        ObjectBuffer.clear();
    }

    /* Очищаем коллекцию */
    public static void clearObjectList()
    {
        // Чистим буффер
        for (Iterator<GameObj> iter = GameObj.ObjectBuffer.iterator(); iter.hasNext();)
        {
            GameObj go = iter.next();
            go.remove();
            iter.remove();
        }
        // Чистим основную коллекцию
        for (Iterator<GameObj> iter = GameObj.ObjectList.iterator(); iter.hasNext();)
        {
            GameObj go = iter.next();
            go.remove();
            iter.remove();
        }
    }

    /* ====== FIELDS ====== */

    protected boolean toRemove = false;
    public boolean ToRemove(){return toRemove;}

    public float x = 0;
    public float y = 0;
    public Vector2 v = new Vector2(0,0);
    public Vector2 a = new Vector2(0,0);
    public int hp = 100;

    public Rectangle hitZone;

    /* Путь относительно папки gfx. Является ключом */
    private Texture texture;

    /* X и Y центра текстуры */
    public float centX()
    {
        return x+getTexture().getWidth()/2;
    }
    public float centY()
    {
        return y+getTexture().getHeight()/2;
    }

    public Texture getTexture(){return getTextureRegion().getTexture();};
    public abstract TextureRegion getTextureRegion();

    public void setTexture(Texture t){
        texture = t;
    }

    /* ====== METHODS ====== */

    /* Получение текущего класса */
    protected Class getClassType()
    {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), 0);
    }

    /* texCode - код текстуры дочернего объекта */
    public GameObj(float ix, float iy) {
        this.x = ix-(getTexture().getWidth()/2);
        this.y = iy-(getTexture().getHeight()/2);
        hitZone = new Rectangle(ix-(getTexture().getWidth()/2),
                iy-(getTexture().getHeight()/2),
                getTexture().getWidth()/2,
                getTexture().getHeight()/2);
        AddToObjectList(this);
        toRemove = false;
    }

    public void moveTo(Vector2 pos)
    {
        x+=pos.x;
        y+=pos.y;
    }

    /* Выстрел */
    protected void shot(){};

    /* Апдейт объекта */
    public void update(){
        /* Цепляем хитзону к координатам объекта */
//        hitZone.setX(x-(getTexture().getWidth()/2));
//        hitZone.setY(y-(getTexture().getHeight()/2));
    }

    /* Очистка */
    public void remove(){
        setTexture(null);
    }
}
