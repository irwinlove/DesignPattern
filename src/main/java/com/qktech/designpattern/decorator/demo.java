package com.qktech.designpattern.decorator;

public class demo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Component component1 = new ConcreteDecorator(new ConcreteComponent());
        component1.operation();

    }
}
