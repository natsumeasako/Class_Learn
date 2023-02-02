package com.learn.class_;

import com.learn.Cat;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class Class_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class类对象不是new出来的，是系统创建的
        //类的加载只有一次，同一个类的Class对象相同
        //Cat cat = new Cat();
        //public Class<?> loadClass(String name) throws ClassNotFoundException {
        //        return loadClass(name, false);
        //    }
        //对象知道自己是哪一个Class对象所生成的
        Class aClass1 = Class.forName("com.learn.Cat");
        Class aClass2 = Class.forName("com.learn.Cat");
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
    }
}
