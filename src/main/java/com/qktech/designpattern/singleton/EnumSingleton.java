package com.qktech.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * @Author irwin
 * @CreateAt 2019/12/17 10:35
 * @Description This is description of class: 枚举类单例及反射攻击
 * @Since version-1.0
 */
public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }
}

class EnumSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        EnumSingleton instance1 = EnumSingleton.INSTANCE;
//        EnumSingleton instance2 = EnumSingleton.INSTANCE;
//        System.out.println(instance1.equals(instance2));
        //反射攻击
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,Integer.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance = declaredConstructor.newInstance("INSTANCE",0);
        //System.out.println(EnumSingleton.INSTANCE.equals(instance));
    }
}

