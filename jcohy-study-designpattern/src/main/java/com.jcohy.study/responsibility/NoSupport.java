package com.jcohy.study.responsibility;


/**
 * 解决问题具体类（永远不处理）
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }
    //解决的方法，自己不做处理
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }

}
