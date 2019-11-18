//package com.jcohy.study.java12;
//
///**
// * Copyright: Copyright (c) 2019 www.xuanwuai.cn
// *
// * @author jiac
// * @version v1.0.0
// * @Description: TODO 请添加该类的功能描述
// * @date 2019/10/31 18:22
// * <p>
// * Modification History:
// * Date         Author          Version            Description
// * ----------------------------------------------------------------------------------*
// * 2019/10/31      jiac           v1.0.0               修改原因
// */
//
//
//public class SwitchTest2 {
//    public static void main(String[] args) {
//        Week day = Week.FRIDAY;
//        int numLetters = switch (day) {
//            case MONDAY, FRIDAY, SUNDAY -> 6;
//            case TUESDAY -> 7;
//            case THURSDAY, SATURDAY -> 8;
//            case WEDNESDAY -> 9;
//            default -> throw new IllegalStateException("What day is today?" + day);
//        };
//    }
//}