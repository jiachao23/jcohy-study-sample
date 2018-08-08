package com.jcohy.study.responsibility;


/**
 * 解决问题具体类（解决特殊号码的问题）
 */
public class SpecialSupport extends Support {

    private int number;//只能解决此号码的问题
    public SpecialSupport(String name,int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber()==number) {
            return true;
        }
        return false;
    }

}
