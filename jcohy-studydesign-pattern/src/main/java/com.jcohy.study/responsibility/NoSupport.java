package com.jcohy.study.responsibility;


/**
 * �����������ࣨ��Զ������
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }
    //����ķ������Լ���������
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }

}
