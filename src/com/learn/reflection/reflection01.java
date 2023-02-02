package com.learn.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.learn.Cat"
        String methodName = properties.get("method").toString();//"hi"
        //反射机制快速入门
        //(1) 加载类, 返回Class类型的对象aClass
        Class aClass = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.hspedu.Cat 的对象实例
        //Object o = aClass.newInstance(); 方法过时建议用下列方法
        Object o = aClass.getConstructor().newInstance();
        //Cat o = (Cat)aClass.newInstance();
        //o.methodName();//错误的 methodName "hi"
        //o.hi();//没有体现反射的价值和意义
        System.out.println("o的运行类型=" + o.getClass());
        //(3) 通过getMethod 在反射中可以把方法视为对象
        // 通过加载的类 com.learn.Cat 的 methodName"方法名" 的方法对象
        // 得到 Cat.方法名 对象
        Method method = aClass.getMethod(methodName);
        method.invoke(o);//方法.invoke(对象)

        //获得成员变量（不能是私有的）
        Field age = aClass.getField("age");
        System.out.println(age.get(o));

        //获得构造器
        Constructor constructor = aClass.getConstructor();//无参构造器
        System.out.println(constructor);

        Constructor constructor1 = aClass.getConstructor(String.class);//有参构造器 String.class 就是String类的Class对象
        System.out.println(constructor1);
    }
}
