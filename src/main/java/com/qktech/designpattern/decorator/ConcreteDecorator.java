package com.qktech.designpattern.decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        System.out.println("添加延时拍照功能。");
    }
}
