package com.qktech.designpattern.singleton;

/*
 * @Author irwin
 * @CreateAt 2019/12/17 9:33
 * @Description This is description of class: 饿汉模式
 * @Since version-1.0
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
//        HungrySingleton instance1 = HungrySingleton.getInstance();
//        HungrySingleton instance2 = HungrySingleton.getInstance();
//        System.out.println(instance1==instance2);
        new Thread(()->{
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).run();
        new Thread(()->{
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).run();

    }
}

class HungrySingleton {
    //hungry单例模式是指类加载的初始化阶段就完成了实例的初始化
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}