package com.jcohy.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jiac on 2019/3/20.
 * ClassName  : com.jcohy.study.nio
 * Description  :
 */
public class TestSocketBuffer {

    @Test
    public void selector() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //调用Selector静态工厂创建一个选择器
        Selector selector = Selector.open();
        //创建一个服务端的channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置非阻塞
        ssc.configureBlocking(false);
        //绑定到socket对象
        ssc.socket().bind(new InetSocketAddress(8080));
        //确认监听的事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //取得所有key的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    iterator.remove();
                }else if((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    while (true){
                        buffer.clear();
                        int n = socketChannel.read(buffer);
                        System.out.println(n);
                        if(n<=0){
                            break;
                        }
                        buffer.flip();
                    }
                    iterator.remove();
                }
            }
        }

    }
}
