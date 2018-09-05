package com.jcohy.study.anno;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.anno
 * Description  :
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();
}
