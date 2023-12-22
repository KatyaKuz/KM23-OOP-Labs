package org.fpm.di;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab3_Binder implements Binder {
        private HashMap<String, Class> binder_class=new HashMap<>();
        private HashMap<String, Object> binder_obj=new HashMap<>();
        @Override
        public <T> void bind(Class<T> clazz) {
                binder_class.put(clazz.getName(), clazz);
                binder_obj.remove(clazz.getName());
        }

        @Override
        public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
                binder_class.put(clazz.getName(), implementation);
                binder_obj.remove(clazz.getName());
        }

        @Override
        public <T> void bind(Class<T> clazz, T instance) {
                binder_obj.put(clazz.getName(), instance);
                binder_class.remove(clazz.getName());
        }
        public  Class get_Class(Class clazz){
              if (binder_class.containsKey(clazz.getName())){
                      return binder_class.get(clazz.getName());
              }
              else{
                      if (binder_obj.containsKey(clazz.getName())){
                              return binder_obj.get(clazz.getName()).getClass();
                      }
              }
              return null;
        }
        public  Object get_Object(Class clazz){
                if (binder_obj.containsKey(clazz.getName())){
                        return binder_obj.get(clazz.getName());
                }
                return null;
        }
}
