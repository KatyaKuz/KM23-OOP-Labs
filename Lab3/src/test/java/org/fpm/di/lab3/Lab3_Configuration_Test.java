package org.fpm.di.lab3;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;

public class Lab3_Configuration_Test implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(TestSingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);
        binder.bind(UseAB.class);
        binder.bind(UseC.class);
        binder.bind(UseP6.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        binder.bind(D.class, E.class);
        binder.bind(E.class);
    }
}
