package com.jcohy.study.java9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/10/31 14:11
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/10/31      jiac           v1.0.0               修改原因
 */


public class MyInterfaceImpl implements MyInterface {
    @Override
    public void normalInterfaceMethod() {
        System.out.println("实现接口的方法");
    }

    @Override
    public void methodDefault1() {

    }

    @Override
    public void methodDefault2() {

    }
    private List<String> flattenStrings(List<String>... lists) {
        Set<String> set = new HashSet<>(){};
        for(List<String> list : lists) {
            set.addAll(list);
        }
        return new ArrayList<>(set);
    }
}
