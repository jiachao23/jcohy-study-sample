package com.jcohy.study.responsibility;

/**
 * 解决问题的抽象类
 *
 * @author jiachao
 */
public abstract class Support {
    // 问题解决者的名称
    private String name;
    // 转向位置
    private Support next;

    // 产生问题的解决者
    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }
    //尚未解决的
    protected  void fail(Trouble trouble) {
        System.out.println(trouble+"cannot be resolved !");
    }
    //已解决
    protected  void done(Trouble trouble) {
        System.out.println(trouble+"is resolved by"+ this);
    }
    //解决的方法
    protected abstract boolean resolve(Trouble trouble);

    @Override
    public String toString() {
        return "Support [name=" + name + "]";
    }

}

