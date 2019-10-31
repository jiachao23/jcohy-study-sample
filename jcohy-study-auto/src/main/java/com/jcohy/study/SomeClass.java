package com.jcohy.study;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/9/2 15:27
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/9/2      jiac           v1.0.0               修改原因
 */


@AutoFactory
final class SomeClass {
    private final String providedDepA;
    private final String depB;

    SomeClass(@Provided String providedDepA, String depB) {
        this.providedDepA = providedDepA;
        this.depB = depB;
    }

    // …
}