package com.jcohy.study.builder;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public abstract class Builder {
    /**
     * �ý���ģʽ�������ļ����ĳ����ļ��������£�
     * 1.����һ������
     * 2.����һЩ�ַ���
     * 3.����һЩ����Ŀ���ŵ���Ŀ
     * Builer��涨������ļ��ķ�������Director��������Щ�������ܲ���1��������ļ�
     * @param title
     */
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract Object getResult();
}
