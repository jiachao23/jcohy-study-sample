package com.jcohy.study;

import org.junit.Test;

import java.util.Optional;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/10 9:09
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/10      jiac           v1.0.0               修改原因
 */


public class Test1 {

    @Test
    public void Test1(){
        Optional<String> pwd = Optional.ofNullable(null);
        String password = pwd.orElse("123456");
        System.out.println(password);
    }
}
