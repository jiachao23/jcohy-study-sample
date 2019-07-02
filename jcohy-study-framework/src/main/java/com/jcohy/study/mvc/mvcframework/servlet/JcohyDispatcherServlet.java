package com.jcohy.study.mvc.mvcframework.servlet;

import com.jcohy.study.mvc.mvcframework.HandlerMapping;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyAutowired;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyController;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyRequestMapping;
import com.jcohy.study.mvc.mvcframework.annotation.JcohyService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiac on 2019/3/21.
 * ClassName  : com.jcohy.study.mvc.mvcframework.servlet
 * Description  :
 */
public class JcohyDispatcherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();
    private List<String> className = new ArrayList<>();

    private Map<String,Object> ioc = new HashMap<>();

    private List<HandlerMapping> handlerMappings = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //6、等待请求阶段
        try {
            doDispatcher(request,response);
        } catch (Exception e) {
            response.getWriter().write("500");
            e.printStackTrace();
        }
    }

    private void doDispatcher(HttpServletRequest request,HttpServletResponse response) throws Exception {

        HandlerMapping handlerMapping = getHandlerMapping(request);
        if(null==handlerMapping){
            response.getWriter().write("404 Not Found");
            return;
        }
        //获取方法参数列表
        Class<?>[] parameterTypes = handlerMapping.getMethod().getParameterTypes();
        //保存所有需要自动赋值的参数值
        Object[] paramValues = new Object[parameterTypes.length];

        Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> params:parameterMap.entrySet()){
            String value = Arrays.toString(params.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "");
            if(!handlerMapping.getParamIndexmapping().containsKey(params.getKey())){continue;}
            Integer index = handlerMapping.getParamIndexmapping().get(params.getKey());
            paramValues[index] = convert(parameterTypes[index],value);
        }
        int reqIndex = handlerMapping.getParamIndexmapping().get(HttpServletRequest.class.getName());
        int resIndex = handlerMapping.getParamIndexmapping().get(HttpServletResponse.class.getName());
        paramValues[reqIndex] = request;
        paramValues[resIndex] = response;
        Object invoke = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
    }

    private Object convert(Class<?> parameterType, String value) throws IllegalAccessException, InstantiationException {

        if(Integer.class == parameterType){
            return Integer.valueOf(value);
        }
        return value;
    }

    private HandlerMapping getHandlerMapping(HttpServletRequest request) {

        if(handlerMappings.isEmpty()){
            return null;
        }

        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        for(HandlerMapping handlerMapping:handlerMappings){
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if(!matcher.matches()){
                continue;
            }
            return handlerMapping;
        }
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我启动了");
        //1、加载配置文件
        doLoadConfig(servletConfig.getInitParameter("contextConfigLocation"));
        //2、扫描所有相关联的类
        doScanner(contextConfig.getProperty("scanPackage"));
        //3、初始化所有相关联的类，并将其保存在IOC容器中
        doInstance();
        //4、执行依赖注入
        doAutowired();
        //5、构建HandlerMapping，将URL和Method进行关联
        initHandlerMapping();
        System.out.println("Jcohy mvc framework is init ");
    }

    private void initHandlerMapping() {
        if(ioc.isEmpty()){
            return;
        }
        for(Map.Entry<String,Object> entry:ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            String baseUrl = "";
            if(clazz.isAnnotationPresent(JcohyRequestMapping.class)){
                JcohyRequestMapping requestMapping = clazz.getAnnotation(JcohyRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            Method[] methods = clazz.getMethods();
            for(Method method:methods){
                if(!method.isAnnotationPresent(JcohyRequestMapping.class)){continue;}
                JcohyRequestMapping methodAnnotation = method.getAnnotation(JcohyRequestMapping.class);
                baseUrl += methodAnnotation.value();
                handlerMappings.add(new HandlerMapping(entry.getValue(),method, Pattern.compile(baseUrl)));
                System.out.println("handlerMapping : "+baseUrl+","+method);
            }

        }
    }

    private void doAutowired() {

        if(ioc.isEmpty()){return;}
        for(Map.Entry<String,Object> entry:ioc.entrySet()){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();

            for(Field field:fields){
                if(!field.isAnnotationPresent(JcohyAutowired.class)){continue;}
                field.setAccessible(true);
                JcohyAutowired autowired = field.getAnnotation(JcohyAutowired.class);
                String beanName = autowired.value();
                if("".equals(beanName.trim())){
                    beanName = field.getType().getName();
                }
                try {
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        if(className == null ){
            return;
        }
        for(int i =0 ;i<className.size();i++){
            try {
                Class<?> clazz = Class.forName(className.get(i));
                if(clazz.isAnnotationPresent(JcohyController.class)){
                    Object instance = clazz.newInstance();
                    //bean名称命名规则：1、首字母小写。2、自定义名称。3、自动类型匹配
                    String beanName = lowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,instance);
                }else if(clazz.isAnnotationPresent(JcohyService.class)){
                    //
                    JcohyService requestMapping = clazz.getAnnotation(JcohyService.class);
                    String beanName = requestMapping.value();
                    if("".equals(beanName.trim())){
                        beanName = lowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName,instance);
                    //3、自动类型匹配
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class inter:interfaces) {
                        ioc.put(inter.getName(),instance);
                    }
                }else{
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private String lowerFirstCase(String simpleName) {
        char[] charName = simpleName.toCharArray();
        charName[0]+=32;
        return String.valueOf(charName);
    }

    private void doScanner(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        File files = new File(url.getPath());
        for(File file:files.listFiles()){
            if(file.isDirectory()){
                doScanner(basePackage+"."+file.getName());
            }else{
                String fileName = basePackage+"."+file.getName().replace(".class","");
                className.add(fileName);
                System.out.println(fileName);
            }
        }

    }

    private void doLoadConfig(String location) {
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            contextConfig.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != resource){
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
