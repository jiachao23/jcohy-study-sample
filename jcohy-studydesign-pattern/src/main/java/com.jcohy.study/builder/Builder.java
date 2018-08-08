package com.jcohy.study.builder;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public abstract class Builder {
    /**
     * 用建造模式建立“文件”的程序。文件构造如下：
     * 1.含有一个标题
     * 2.含有一些字符串
     * 3.含有一些有项目符号的项目
     * Builer类规定了组成文件的方法。而Director类利用这些方法才能产生1个具体的文件
     * @param title
     */
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract Object getResult();
}
