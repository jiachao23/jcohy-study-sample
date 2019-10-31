package com.jcohy.study.java9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/10/31 14:47
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/10/31      jiac           v1.0.0               修改原因
 */


public class CollectionTest {

    @Test
    public void jdk8(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe"); namesList.add("Bob");
        namesList.add("Bill");
        namesList = Collections.unmodifiableList(namesList);
        System.out.println(namesList);
    }

    @Test
    public void jdk9(){
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe"); namesList.add("Bob");
        namesList.add("Bill");
        namesList = Collections.unmodifiableList(namesList);
        System.out.println(namesList);
    }
}
