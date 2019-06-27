package com.jcohy.study.nio;

/**
 * Created by jiac on 2018/12/4.
 * ClassName  : com.jcohy.study
 * Description  :
 */

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用 NIO 完成网络通信的三个核心：
 *
 * 1. 通道（Channel）：负责连接
 *
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 *
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 *
 * 2. 缓冲区（Buffer）：负责数据的存取
 *
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 */
public class TestBlockingNIO {

    /**
     *  客户端
     */
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel fileChannel = FileChannel.open(Paths.get("D:\\413.avi"), StandardOpenOption.READ);

        //2.分配一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //3.读取本地文件，并发送到服务端
        while (fileChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.shutdownOutput();
        //4.接受到服务端反馈
        int len = 0;
        while((len = socketChannel.read(buffer)) != -1){
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        socketChannel.close();
        fileChannel.close();
    }

    /**
     * 服务端
     * @throws IOException
     */
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\get.avi"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2.绑定连接
        socketChannel.bind(new InetSocketAddress(9898));
        //3.获取客户端连接的通道
        SocketChannel accept = socketChannel.accept();
        //4. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //5. 接收客户端的数据，并保存到本地
        while (accept.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        //6.发送反馈给客户端
        buffer.put("服务端接收数据成功".getBytes());
        buffer.flip();
        accept.write(buffer);

        socketChannel.close();
        outChannel.close();
        accept.close();
    }
}
