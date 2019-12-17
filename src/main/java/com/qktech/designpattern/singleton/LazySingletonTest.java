package com.qktech.designpattern.singleton;

/**
 * @Author irwin
 * @Date 2019/12/16 10:53
 * @Description This is description of class: LazySingletonTest
 * @Since version-1.0
 */
public class LazySingletonTest {
    public static void main(String[] args) {
//        LazySingleton instance = LazySingleton.getInstance();
////        LazySingleton instance1 = LazySingleton.getInstance();
////        System.out.println(instance.equals(instance1));
        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}


class  LazySingleton {
    //lazy单例模式，延迟加载，只有真正使用的时候，才开始实例化
    private static volatile LazySingleton instance;
    private LazySingleton() {
    }

    public static  LazySingleton getInstance() {
        if (instance == null) {
           synchronized ( LazySingleton.class){
               if (instance == null){
                   instance = new LazySingleton();
               }
           }

        }
        return instance;
    }
}
