package com.learn.reflection;

import java.lang.reflect.Field;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class ReflectionAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> student = Class.forName("com.learn.reflection.student");
        Object o = student.newInstance();
        Field age = student.getField("age");
        // 通过反射对属性设置值
        age.set(o,20);
        // 通过反射操作name
        Field name = student.getDeclaredField("name");
        // 暴破
        name.setAccessible(true);
        // null是因为name属性是static，所有student对象共享同一个name
        // name.set(o,"asahi");
        name.set(null,"asahi");
        System.out.println(o);
        System.out.println(name.get(null));// 要求name是static
    }
}

class student {
    public int age;
    private static String name;

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "age=" + age + ",name=" + name +
                '}';
    }
}