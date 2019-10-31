package com.jcohy.study.java9;

import java.io.*;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/10/31 14:26
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/10/31      jiac           v1.0.0               修改原因
 */


public class tryTest {
    //jdk 1.8 以前
    public void test1(){
        //jdk1.8以前
        InputStreamReader reader = null;
        try{
            reader = new InputStreamReader(System.in);
            //流的操作
            reader.read();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test2(){
        //jdk 1.8
        try(InputStreamReader reader = new InputStreamReader(System.in)){

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void test3(){
        //jdk 1.9
        InputStreamReader reader = new  InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try(reader;writer){
            //reader是final的，不可再被赋值
            //reader = null;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
