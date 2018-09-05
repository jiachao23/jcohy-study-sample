package com.jcohy.study.stream;

import com.jcohy.study.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by jiac on 2018/9/5.
 * ClassName  : com.jcohy.study.stream
 * Description  :
 */
public class TestStream4 {


    List<Employee> emps = Arrays.asList(
            new Employee(102, "����", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "����", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "����", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "����", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "����", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "����", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "����", 38, 5555.55, Employee.Status.BUSY)
    );

    /*
	  	1.	����һ�������б���η���һ����ÿ������ƽ�����ɵ��б��أ�
		��������1��2��3��4��5���� Ӧ�÷��ء�1��4��9��16��25����
	 */
    @Test
    public void test1(){
        Integer[] arrays = new Integer[]{1,2,3,4,5};
        Arrays.stream(arrays)
                .map((x) -> x * x)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /*
	 2.	������ map �� reduce ������һ�������ж��ٸ�Employee�أ�
	 */

    @Test
    public void test2(){
        Optional<Integer> reduce = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
