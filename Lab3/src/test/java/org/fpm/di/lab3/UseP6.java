package org.fpm.di.lab3;

import javax.inject.Inject;

public class UseP6 {
    private final UseAB dependency;
    private final A dependencyA;

    @Inject
    public UseP6(A a1, A a2, A a3, A a4, A a5, UseAB d) {
        this.dependency = d;
        this.dependencyA = a1;
    }

    public UseAB getDependency() {
        return dependency;
    }
}
