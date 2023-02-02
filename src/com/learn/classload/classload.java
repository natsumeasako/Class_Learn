package com.learn.classload;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class classload {
    public static void main(String[] args) {
        // 1. 加载b类，生成b的class对象
        // 2. 连接 默认初始化 num = 0
        // 验证SecurityManager
        // 3. 初始化阶段
        // 依次自动合并所有的静态变量的赋值动作和静态代码块中的语句
        // clinit(){ // 在多线程环境中会正确的加锁、同步
        //      System.out.println("b 静态代码块..");
        //      //num = 300;
        //      num = 100;
        // }
        // protected Class<?> loadClass(String name, boolean resolve)
        //        throws ClassNotFoundException
        // {
        //        synchronized (getClassLoadingLock(name)) {// 同步代码块
        //        }
        // }
        new b();
    }
}

class b {
    static {
        System.out.println("b 静态代码块..");
        num = 300;
    }

    static int num = 100;

    public b() {
        System.out.println("b 构造器..");
        System.out.println(num);
    }
}