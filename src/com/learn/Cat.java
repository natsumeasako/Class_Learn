package com.learn;

/**
 * @author Asahi
 */
@SuppressWarnings({"all"})
public class Cat {
    public String name = "招财猫";
    public int age = 10; //public的
    private String color = "橘猫";

    public Cat() {
    } //无参构造器

    public Cat(String name) {
        this.name = name;
    }

    public void hi() { //常用方法
        //System.out.println("hi " + name);
    }

    public void cry() {
        System.out.println("cry " + name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
