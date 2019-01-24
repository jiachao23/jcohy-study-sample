package com.jcohy.study.java8.anno;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.java8.anno
 * Description  :
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();
}
