package com.jcohy.study.java8.stream;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/11/1 11:18
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/11/1      jiac           v1.0.0               修改原因
 */


public class PartialFunctions {
    private static <T,U,R> Function<U,R> partialLeft(BiFunction<T,U,R> biFunction,T t){
        return (u -> biFunction.apply(t,u));
    }

    private static <T,U,R> Function<T,R> partialRight(BiFunction<T,U,R> biFunction,U u){
        return (t -> biFunction.apply(t,u));
    }

    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction = (v1,v2) -> v1*v2;
        Function<Integer,Integer> subtractFrom10 = partialLeft(biFunction,10);
        Function<Integer,Integer> subtractBy10 = partialRight(biFunction,10);
        System.out.println(subtractFrom10.apply(5));
        System.out.println(subtractBy10.apply(5));
    }
}

