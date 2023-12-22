package org.fpm.di.lab3;

import javax.inject.Inject;

public class UseC {
    private final C dependency;

    @Inject
    public UseC(C c) {
        this.dependency = c;
    }

    public C getDependency() {
        return dependency;
    }
}
