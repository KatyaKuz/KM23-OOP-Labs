package org.fpm.di;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Lab3_Container implements Container {
    Lab3_Binder binder=new Lab3_Binder();
    //HashMap список об'єктів Singleton
    HashMap<String, Object> sing_obj=new HashMap<>();
    public Lab3_Container (Configuration conf){
        //Завантаження конфігурації контейнера
        conf.configure(binder);
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        boolean is_sing=false; //Признак Singleton
        Object o; //Об'єкт для результату
        Constructor[] c; //Масив конструкторів об'єкту
        Class cl=binder.get_Class(clazz); //Перевірка, що клас зареєстрований через bind
        if (cl!=null){
            o=binder.get_Object(cl);
            if (o==null){
                c=cl.getConstructors();
                if (c.length>1){
                    throw new IllegalArgumentException("Об'єкт не може містити більше одного конструктора.");
                }
                Class[] p =c[0].getParameterTypes(); //Масив типів параметрів конструктора об'єкту
                ArrayList<Object> po=new ArrayList<Object>(); //Масив об'єктів для параметрів об'єктів
                Annotation[] a; //Масив аннотацій класа для превірки Singleton
                a=cl.getAnnotations();
                for (int i=0; i<a.length; i++){
                    if (Objects.equals(a[i].toString(), "@javax.inject.Singleton()")){ //Переврка Singleton
                        is_sing=true;
                        break;
                    }
                }
                if (is_sing){
                    if (sing_obj.containsKey(cl.getName())){ //Перевірка,що Singleton вже створений
                        return (T) sing_obj.get(cl.getName()); //Повертаємо існуючий Singleton
                    }
                }
                if (p.length>5){
                    throw new IllegalArgumentException("Конструктор об'єкта не може містити більше 5 параметрів.");
                }
                for (int i = 0; i < p.length; i++) {
                    o=this.getComponent(p[i]);
                    if (o == null) {
                        throw new IllegalArgumentException("Клас "+cl.getName()+" для конструктора потребує параметер "+p[i].getName()+" який не обробляється контейнером.");
                    }
                    po.add(o); //Створення об'єкту для параметрів
                }
                try {
                    //Створення об'єкту в залежності від кількості параметрів
                    switch (p.length) {
                        case (0):
                            o = (T) c[0].newInstance();
                            break;
                        case (1):
                            o= (T) c[0].newInstance(po.get(0));
                            break;
                        case (2):
                            o= (T) c[0].newInstance(po.get(0), po.get(1));
                            break;
                        case (3):
                            o= (T) c[0].newInstance(po.get(0), po.get(1), po.get(2));
                            break;
                        case (4):
                            o= (T) c[0].newInstance(po.get(0), po.get(1), po.get(2), po.get(3));
                            break;
                        default:
                            throw new IllegalArgumentException("Конструктор об'єкта не може містити більше 5 параметрів.");
                    }
                    if (is_sing){
                        sing_obj.put(cl.getName(), o); //Збереження в список створених об'єктів Singleton
                    }
                    return (T) o;
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                return (T) o;
            }
        }
        return null;
    }
}