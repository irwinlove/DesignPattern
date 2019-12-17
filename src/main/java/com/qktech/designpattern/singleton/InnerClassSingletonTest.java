package com.qktech.designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * @Author irwin
 * @CreateAt 2019/12/17 9:56
 * @Description This is description of class: 静态内部类单例 + 反射攻击
 * @Since version-1.0
 */
public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
//        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
//        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
//        System.out.println(instance1.equals(instance2));
//        new Thread(()->{
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).run();
//        new Thread(()->{
//            InnerClassSingleton instance = InnerClassSingleton.getInstance();
//            System.out.println(instance);
//        }).run();
        //-----反射攻击
//        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        InnerClassSingleton instance = declaredConstructor.newInstance();
//        System.out.println(InnerClassSingleton.getInstance().equals(instance));
        //序列化
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testSerializable"));
//        oos.writeObject(instance);
//        oos.close();
        //反序列化
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingleton o = ((InnerClassSingleton) ois.readObject());
        System.out.println(o.equals(instance));

    }
}
class InnerClassSingleton implements Serializable {
    static final long serialVersionUID=34L;
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton(){}
    public static InnerClassSingleton getInstance(){

        return InnerClassHolder.instance;
    }
    Object readResolve() throws ObjectStreamException{
        return InnerClassHolder.instance;//序列化时读取版本号serialVersionUID
    }
}
