package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by $lyl on 2017/8/19.
 */

public class ParseAnn {

    //只有在 RUNTIME 时候好用
    //SOURCE　CLASS　都不能用

    public static void main(String[] args) {
        // 1 使用类加载器加载类
        try {
            Class c = Class.forName("com.example.Child");
            //2.找到类上面的注解
            boolean isExist = c.isAnnotationPresent(Description.class);

            if (isExist) {
                //3.拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //4.找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m
                    : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //另外一种解析方法

            for (Method m : ms){
                Annotation [] as = m.getAnnotations();
                for (Annotation a :
                        as) {
                    if (a instanceof Description){
                        Description d = (Description) a;
                        System.out.println(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
