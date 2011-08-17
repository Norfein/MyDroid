package com.mydroid.game.manage;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

/**
 * Менеджер звуков
 */
public class SoundManager {

    private HashMap<String, Sound> ResourceMap = new HashMap<String, Sound>();

    public synchronized HashMap<String, Sound> getResourceMap(){return ResourceMap;};

    /* Реализуем как синглтон */
    private static SoundManager _sManager = null;
    private SoundManager() {}
    public static synchronized SoundManager getInstance()
    {
        if (_sManager == null)
            _sManager = new SoundManager();
        return _sManager;
    }

    private String dir="sound/";

//    public Sound addToSoundMap(String key, Sound sound)
//    {
//        return addToMap(key, sound);
//    }
//
//    public void removeFromSoundMap(String key)
//    {
//        removeFromMap(key);
//    }

    protected Sound add(String key, Sound iTexture)
    {
        return getResourceMap().put(key, iTexture);
    }

    /* Удаление текстуры */
    protected void remove(String key)
    {
        if (getResourceMap().containsKey(key))
        {
            getResourceMap().remove(key);
        }
    }
    protected void remove(Sound res)
    {
        if (getResourceMap().containsValue(res))
        {
            getResourceMap().remove(res);
        }
    }

    public Sound get(String path) {
        Sound s = getResourceMap().get(path);
        if (s==null)
        {
            s = Gdx.audio.newSound(Gdx.files.internal(dir+path));
            if (s!=null)
                add(path, s);
        }
        return s;
    }

    /* Проверка на наличие по ключу */
    protected boolean contains(String key)
    {
        return getResourceMap().containsKey(key);
    }

    /* Проверка на наличие по ресурсу */
    protected boolean contains(Sound res)
    {
        return getResourceMap().containsValue(res);
    }

    /* Воспроизвести звук */
    public void playSound(String key)
    {
        if (!contains(key))
            return;
        get(key).play();
    }


    public void clear() {
        if (getResourceMap().isEmpty())
            return;
        for (int i=0; i<getResourceMap().size(); i++)
            getResourceMap().get(i).dispose();
        clear();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
