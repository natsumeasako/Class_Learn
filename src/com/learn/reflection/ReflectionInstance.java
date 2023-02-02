package com.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class ReflectionInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.learn.reflection.User");
        // 通过public无参构造器创建实例
        Object o = aClass.newInstance();
        System.out.println(o);
        // 通过public有参构造器创建实例
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object oyama = constructor.newInstance("oyama");
        System.out.println(oyama);
        // 通过非public有参构造器创建实例
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class);
        // setAccessible()暴破
        declaredConstructor.setAccessible(true);
        Object asahi = declaredConstructor.newInstance(20, "asahi");
        System.out.println(asahi);
    }
}

class User {
    private int age;
    public String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "age=" + age + ",name=" + name;
    }
}