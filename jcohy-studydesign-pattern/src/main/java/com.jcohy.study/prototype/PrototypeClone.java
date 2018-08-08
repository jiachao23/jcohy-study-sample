package com.jcohy.study.prototype;

import java.io.*;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class PrototypeClone implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String string;

    private SerializableObject obj;

    /* ǳ���� */
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /* ��� */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /* д�뵱ǰ����Ķ������� */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* �������������������¶��� */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

}

//Ҫʵ����ƣ���Ҫ����������ʽ���뵱ǰ����Ķ��������룬��д�����������ݶ�Ӧ�Ķ���
class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}