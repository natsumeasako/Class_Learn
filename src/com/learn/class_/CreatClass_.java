package com.learn.class_;

import com.learn.Cat;

/**
 * @author Asahi
 * 创建Class对象的各种方式
 */
@SuppressWarnings({"all"})
public class CreatClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 第一种方式 通过读取配置文件获取
        String path = "com.learn.Cat";
        Class<?> aClass = Class.forName(path);
        System.out.println(aClass);
        // 2. 第二种方式 类名.class 运行类型
        System.out.println(Cat.class);
        // 3. 第三种方式 对象.getClass()
        Cat cat = new Cat();
        Class<? extends Cat> aClass1 = cat.getClass();
        System.out.println(aClass1);
        // 4. 第四种方式 通过类加载器来获取类的Class对象
        // (1) 先得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        // (2) 通过类加载器得到Class对象
        Class<?> aClass2 = classLoader.loadClass(path);
        System.out.println(aClass2);
        // 5. 基本数据类型得到Class类对象 自动装箱拆箱
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int
        // 6. 基本数据类型对应的包装类，可以通过.TYPE 得到Class类对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);//int
    }
}
