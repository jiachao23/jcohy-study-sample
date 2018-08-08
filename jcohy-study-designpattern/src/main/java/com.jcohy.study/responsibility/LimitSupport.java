package com.jcohy.study.responsibility;

/**
 * �����������ࣨ���С��ָ��������ࣩ
 */
public class LimitSupport extends Support {
    private int limit;//��С��κ���ɽ��
    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber()<limit) {
            return true;
        }
        return false;
    }

}
