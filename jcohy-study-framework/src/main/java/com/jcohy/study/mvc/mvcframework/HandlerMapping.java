package com.jcohy.study.mvc.mvcframework;

import com.jcohy.study.mvc.mvcframework.annotation.JcohyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.mvcframework
 * Description  :
 */
public class HandlerMapping {

    //保存方法对应的实例
    private Object controller;
    //保存映射的方法
    private Method method;
    //Request路径匹配规则
    private Pattern pattern;
    //参数顺序
    private Map<String,Integer> paramIndexmapping;

    public HandlerMapping(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;

        paramIndexmapping = new HashMap<>();

        putParamIndexMapping(method);
    }

    public void putParamIndexMapping(Method method) {

        //提取方法中加了注解的参数
        Annotation[][] annotations = method.getParameterAnnotations();
        for(int i =0 ;i< annotations.length; i++){
            for(Annotation annotation:annotations[i]){
                if(annotation instanceof JcohyRequestParam){
                    String paramName = ((JcohyRequestParam) annotation).value();
                    if(!"".equals(paramName.trim())){
                        paramIndexmapping.put(paramName,i);
                    }

                }
            }
        }
        //提取request和response参数
        Class<?>[] parameterTypes = method.getParameterTypes();
        for(int i=0;i<parameterTypes.length;i++){
            Class<?> clazz = parameterTypes[i];
            if(clazz == HttpServletRequest.class || clazz == HttpServletResponse.class){
                paramIndexmapping.put(clazz.getName(),i);
            }
        }
    }

    public Object getController() {
        return controller;
    }

    public Method getMethod() {
        return method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Map<String, Integer> getParamIndexmapping() {
        return paramIndexmapping;
    }
}
