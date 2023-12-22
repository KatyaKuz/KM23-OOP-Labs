package org.fpm.di.lab3;

import javax.inject.Inject;

public class UseAB {
    private final A dependencyA;
    private B dependencyB=null;

    @Inject
    public UseAB(A a) {
        this.dependencyA = a;
    }
    @Inject
    public UseAB(A a, B b) {
        this.dependencyA = a;
        this.dependencyB = b;
    }

    public A getDependencyA() {
        return dependencyA;
    }
    public B getDependencyB() {
        return dependencyB;
    }
}
