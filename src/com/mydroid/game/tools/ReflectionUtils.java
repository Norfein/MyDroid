package com.mydroid.game.tools;

import java.lang.reflect.ParameterizedType;

/**
 * Created by IntelliJ IDEA.
 * User: NOR00
 * Date: 14.08.11
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionUtils {
    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
    return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
  }
}
