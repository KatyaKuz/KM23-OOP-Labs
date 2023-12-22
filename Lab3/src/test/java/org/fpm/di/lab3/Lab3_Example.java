package org.fpm.di.lab3;

import org.fpm.di.Lab3_Container;
import org.fpm.di.Lab3_Environment;

public class Lab3_Example {
    private static Lab3_Container container;

    public static void main(String[] args) {
        Lab3_Environment env = new Lab3_Environment();
        container = (Lab3_Container) env.configure(new MyConfiguration());

        Object b=container.getComponent(B.class);
        System.out.println("Отриманий об'єкт класу В: "+b);

        Object so1=container.getComponent(MySingleton.class);
        Object so2=container.getComponent(MySingleton.class);
        System.out.println("\nОтриманий об'єкт 1 класу MySingleton: "+so1);
        System.out.println("Отриманий об'єкт 2 класу MySingleton: "+so2);

        Object po1=container.getComponent(MyPrototype.class);
        Object po2=container.getComponent(MyPrototype.class);
        System.out.println("\nОтриманий об'єкт 1 класу MyPrototype: "+po1);
        System.out.println("Отриманий об'єкт 2 класу MyPrototype: "+po2);

        final B bAsSingleton = container.getComponent(B.class);
        Object ba=container.getComponent(A.class);
        System.out.println("\n binder.bind(A.class, B.class);\n binder.bind(B.class, new B());");
        System.out.println("Для класу А повертається об'єкт класу В: "+ba);
        System.out.println("Для класу В повертається об'єкт класу В: "+bAsSingleton);

        final UseA hasADependency = container.getComponent(UseA.class);
        System.out.println("\nОтриманий об'єкт класу UseA: "+hasADependency);
        System.out.println("В об'єкт класу UseA впроваджений об'єкт класу В: "+hasADependency.getDependency());
    }
}