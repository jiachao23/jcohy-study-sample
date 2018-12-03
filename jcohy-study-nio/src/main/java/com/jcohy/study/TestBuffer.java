package com.jcohy.study;

/**
 * Created by jiac on 2018/12/3.
 * ClassName  : com.jcohy.study
 * Description  :
 */

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区；在java NIO中负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据
 * 根据数据类型不同（boolean外），提供了相应类型的缓冲区
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate（）获取缓冲区
 * 二：缓冲区存取数据的两个核心方法
 * put()
 * get()
 *
 * 三：缓冲区中的四个核心属性
 * capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变。
 * limit：界限，表示缓冲区中可以操作数据的大小，（limit后的数据不能进行读写）
 * position：位置，表示缓冲区中正在操作数据的位置
 * mark:标记，表示记录当前position的位置，可以通过reset()恢复到mark之前的位置
 * 0<=mark<=position<=limit<capacity
 *
 * 四：直接缓冲区与非直接缓冲区
 * 非直接缓冲区：allocate();方法分配缓存区，将缓冲区建立在JVM的内存中
 * 直接缓冲区：通过allocateDirect（）方法分配直接缓冲区。将缓冲区建立在物理内存中
 * */
public class TestBuffer {


    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buffer.position());
        //mark
        buffer.mark();
        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position());

        buffer.reset();
        System.out.println(buffer.position());
    }
    @Test
    public void test1(){
        String str = "abcde";
        //1、分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("-------------allocate----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //2、利用put()存入数据到缓冲区
        buf.put(str.getBytes());

        System.out.println("-------------put----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //3、切换到读取数据的模式
        buf.flip();
        System.out.println("-------------flip----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //4、读取数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("-------------get----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //5、rewind()重读
        buf.rewind();
        System.out.println("-------------rewind----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //6、清空缓冲区，缓冲区中的数据依然存在，但是出于被“遗忘状态”
        buf.clear();
        System.out.println("-------------clear----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }
}
