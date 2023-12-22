package org.fpm.di.lab3;


import org.fpm.di.Lab3_Container;
import org.fpm.di.Lab3_Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class Lab3_Test {

    private Lab3_Container container;

    @BeforeEach
    public void setUp() {
        Lab3_Environment env = new Lab3_Environment();
        container = (Lab3_Container) env.configure(new Lab3_Configuration_Test());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
        assertNotSame(container.getComponent(TestSingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldNotInjectC() {
        assertSame(null, container.getComponent(C.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);

        /*
        binder.bind(D.class, E.class);
        binder.bind(E.class);
        */
        E e1= (E) container.getComponent(D.class);
        E e2= (E) container.getComponent(D.class);
        E e3= (E) container.getComponent(E.class);
        assertNotSame(e1, e2);
        assertNotSame(e1, e3);
        assertNotSame(e2, e3);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void shouldCallException() {
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
           UseAB d =container.getComponent(UseAB.class);
        });
        Assertions.assertEquals("Об'єкт не може містити більше одного конструктора.",thrown1.getMessage());

        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UseC c =container.getComponent(UseC.class);
        });
        Assertions.assertEquals("Клас org.fpm.di.lab3.UseC для конструктора потребує параметер org.fpm.di.lab3.C який не обробляється контейнером.",thrown2.getMessage());

        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            UseP6 p =container.getComponent(UseP6.class);
        });
        Assertions.assertEquals("Конструктор об'єкта не може містити більше 5 параметрів.",thrown3.getMessage());
    }
}