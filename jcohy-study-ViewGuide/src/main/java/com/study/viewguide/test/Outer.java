package com.study.viewguide.test;

/**
 * Created by jiac on 2019/1/29.
 * ClassName  : com.study.viewguide.test
 * Description  :
 */
class Outer {
    class Inner {}
    public static void foo() {
        new Outer().new Inner();
    }
    public void bar() {
        new Inner();
    }
    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
