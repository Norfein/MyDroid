package com.mydroid;

import android.app.Activity;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidInput;
import org.lwjgl.opengl.DisplayMode;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.nio.channels.NonReadableChannelException;

public class AndroidStarter extends AndroidApplication
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        initialize(new MyDroid(), false);
    }



}
