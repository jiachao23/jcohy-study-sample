package com.jcohy.study;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.Selector;

/**
 * Created by jiac on 2018/12/3.
 * ClassName  : com.jcohy.study
 * Description  :
 */
public class TestChannel {

    //非直接缓冲区
    @Test
    public void test1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("");
        Selector selector = Selector.open();
    }
}
