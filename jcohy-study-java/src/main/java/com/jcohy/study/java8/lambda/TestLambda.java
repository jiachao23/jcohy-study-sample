package com.jcohy.study.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by jiac on 2018/9/4.
 * ClassName  : com.jcohy.study.java8.lambda
 * Description  :
 */
public class TestLambda {


    @Test
    public void test1(){
        System.out.println("------�������ൽLambda ��ת��------");

        Runnable r = new Runnable() {
            public void run() {
                System.out.println("hello world");
            }
        };
        r.run();

        System.out.println("-------------------------");

        Runnable r1 = () -> System.out.println("hello world");
        r1.run();
    }

    @Test
    public void test2(){
//        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hello world");
    }

    @Test
    public void test3(){
       Comparator<Integer> com = (x, y) -> {
           System.out.println("����ʽ���");
           return Integer.compare(x,y);
       };

//    Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
    }

    @Test
    public void test4(){
        Integer integer = operation(100, (x) -> x * x);
        System.out.println(integer);
    }

    public Integer operation(Integer num,MyFun myFun){
        return myFun.getValue(num);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101,"����",18,1111.11),
            new Employee(102,"����",59,2222.22),
            new Employee(103,"����",28,3333.33),
            new Employee(104,"����",8,4444.44),
            new Employee(105,"����",38,5555.55),
            new Employee(106,"����",42,6666.66),
            new Employee(107,"��ʮ",69,7777.77)
            );
    @Test
    public void test5(){
        Collections.sort(emps,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee e: emps) {
            System.out.println(e);
        }
    }

    @Test
    public void test6(){
        String helloWorld = operation("Hello World", (str) -> str.toUpperCase());
        String helloWorld1 = operation("He", (str) -> str.substring(2,5));
        System.out.println(helloWorld);
        System.out.println(helloWorld1);
    }

    public String operation(String num,Func1 myFun){
        return myFun.getValue(num);
    }

    @Test
    public void test7(){
        calculate(100L,200L,(a,b) -> a+b);
        calculate(100L,200L,(a,b) -> a*b);
    }

    public void calculate(Long num,Long num2,Func2<Long,Long> myFun){
        System.out.println(myFun.getValue(num,num2));
    }
}
