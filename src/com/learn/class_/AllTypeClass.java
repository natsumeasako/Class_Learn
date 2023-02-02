package com.learn.class_;

import java.io.Serializable;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;//外部类
        Class<Serializable> serializableClass = Serializable.class;//接口
        Class<Integer[]> aClass = Integer[].class;//数组
        Class<float[][]> aClass1 = float[][].class;//二维数组
        Class<Deprecated> deprecatedClass = Deprecated.class;//注解
        Class<Thread.State> stateClass = Thread.State.class;//枚举
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
        System.out.println(stringClass);
        System.out.println(serializableClass);
        System.out.println(aClass);
        System.out.println(aClass1);
        System.out.println(deprecatedClass);
        System.out.println(stateClass);
        System.out.println(voidClass);
        System.out.println(classClass);
    }
}
