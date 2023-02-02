package com.learn.class_;

import java.lang.reflect.Field;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class ClassMathod_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //<?>表示不确定的类型
        Class<?> aClass = Class.forName("com.learn.Cat");
        System.out.println(aClass);
        System.out.println(aClass.getClass());
        //aClass.getPackage().getName() 可以获得这个Cat类在那个包下面
        System.out.println(aClass.getPackage().getName());

        //获得类名
        System.out.println(aClass.getName());

        //获得对象
        Object o = aClass.newInstance();
        System.out.println(o);// toString
        //获得属性
        Field age = aClass.getField("age");
        //可以获得私有属性
        Field color = aClass.getDeclaredField("color");
        System.out.println(color);
        System.out.println(age.get(o));
        //通过反射来重新赋值
        age.set(o, 12);
        System.out.println(age.get(o));
        //拿到所以的字段属性
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "=" + field.get(o));
        }
    }
}
