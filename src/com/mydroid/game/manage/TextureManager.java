package com.mydroid.game.manage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Обёртка под менеджер ресурсов.
 */
public final class TextureManager {

    private HashMap<String, Texture> ResourceMap = new HashMap<String, Texture>();
    public synchronized HashMap<String, Texture> getResourceMap(){return ResourceMap;};

    /* Реализуем как синглтон */
    private static TextureManager _tManager = null;
    private TextureManager() {}
    public static synchronized  TextureManager getInstance()
    {
        if (_tManager == null)
            _tManager = new TextureManager();
        return _tManager;
    }

    public String dir="gfx/";

    /* METHODS */
    /* Добавление текстуры */
    protected Texture add(String key, Texture iTexture)
    {
        return getResourceMap().put(key, iTexture);
    }

    /* Проверка на наличие по ключу */
    protected boolean contains(String key)
    {
        return getResourceMap().containsKey(key);
    }

    /* Проверка на наличие по ресурсу */
    protected boolean contains(Texture res)
    {
        return getResourceMap().containsValue(res);
    }

    public Texture get(String path)
    {
        if (contains(path))
        {
             return getResourceMap().get(path);
        }
        else
        {
            Texture t = new Texture(Gdx.files.internal(dir+path));
            if (t!=null)
                add(path, t);
            return t;
        }
    }

    public void clear() {
        if (getResourceMap().isEmpty())
            return;
        for (int i=0; i<getResourceMap().size(); i++)
            getResourceMap().get(i).dispose();
        getResourceMap().clear();
    }

    /* Удаление текстуры */
    protected void remove(String key)
    {
        if (getResourceMap().containsKey(key))
        {
            getResourceMap().remove(key);
        }
    }
    protected void remove(Texture res)
    {
        if (getResourceMap().containsValue(res))
        {
            getResourceMap().remove(res);
        }
    }
}
