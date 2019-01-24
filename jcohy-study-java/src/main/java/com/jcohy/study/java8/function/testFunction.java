package com.jcohy.study.java8.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by jiac on 2018/9/4.
 * ClassName  : com.jcohy.study.java8.function
 * Description  :
 */
public class testFunction {

    //Consumer<T>
    @Test
    public void test1(){
        happy(100000,(m) -> System.out.println("?????????"+m+"?"));
    }

    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100) );
        for (Integer integer:numList ) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
       String newStr = strHandler("\t\t\t hahah",(str) -> str.trim());
        System.out.println(newStr);
    }


    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("hellsssso","world","atcj","jcohy");
        List<String> str = filterStr(list, (x) -> x.length() > 4);
       for(String str1 :str){
           System.out.println(str1);
       }
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for(String str:list){
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
