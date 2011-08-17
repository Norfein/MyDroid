package com.mydroid;

import com.badlogic.gdx.backends.jogl.JoglApplication;

/**
 * Created by IntelliJ IDEA.
 * User: e_krais
 * Date: 12.08.11
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class DesktopStarter {
    public static void main(String[] argv)
    {
        new JoglApplication(new MyDroid(), "Hell World", 480, 320, false);
    }
}
