package org.fpm.di;

public class Lab3_Environment implements Environment{
    @Override
    public Container configure(Configuration configuration) {
        return new Lab3_Container(configuration);
    }
}