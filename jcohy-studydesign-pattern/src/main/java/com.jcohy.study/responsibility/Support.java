package com.jcohy.study.responsibility;

/**
 * �������ĳ�����
 *
 * @author jiachao
 */
public abstract class Support {
    // �������ߵ�����
    private String name;
    // ת��λ��
    private Support next;

    // ��������Ľ����
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
    //��δ�����
    protected  void fail(Trouble trouble) {
        System.out.println(trouble+"cannot be resolved !");
    }
    //�ѽ��
    protected  void done(Trouble trouble) {
        System.out.println(trouble+"is resolved by"+ this);
    }
    //����ķ���
    protected abstract boolean resolve(Trouble trouble);

    @Override
    public String toString() {
        return "Support [name=" + name + "]";
    }

}

