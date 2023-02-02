package com.learn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> bossClass = Class.forName("com.learn.reflection.Boss");
        Object o = bossClass.newInstance();
        // 得到hi 方法
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "hi");
        // 获得say 方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);// 暴破
        System.out.println(say.invoke(o, 20, "asahi", 'S'));
        Object invoke = say.invoke(null,20, "oyama", 'Y');
        System.out.println(invoke);
    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println(s);
    }
}