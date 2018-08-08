package com.jcohy.study.responsibility;

/**
 * 解决问题具体类（解决小余指定号码的类）
 */
public class LimitSupport extends Support {
    private int limit;//若小余次号码可解决
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
