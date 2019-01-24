package com.jcohy.study.java8.anno;


import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.java8.anno
 * Description  :
 */
public class TestAnnotation {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        for(MyAnnotation myAnnotation: myAnnotations){
            System.out.println(myAnnotation);
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){

    }
}
