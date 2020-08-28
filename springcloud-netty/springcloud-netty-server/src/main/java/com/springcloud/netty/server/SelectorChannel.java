package com.springcloud.netty.server;

import com.springcloud.common.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorChannel {
    private static Logger LOGGER= LoggerFactory.getLogger(SelectorChannel.class);

    public static void main(String[] args) throws IOException {

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        Selector selector=Selector.open();

        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(8080));

        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT );

        while (!Thread.currentThread().isInterrupted()){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();

                while (it.hasNext()){
                    SelectionKey selectionKey=it.next();

                    if(selectionKey.isConnectable()){
                        LOGGER.info("客户端已连接:"+System.currentTimeMillis());
                    }
                    else if(selectionKey.isAcceptable()){
                        LOGGER.info("客户端可获取:"+ TimeUtil.longTransferTime(System.currentTimeMillis()));
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel=channel.accept();
//                        if(socketChannel!=null){
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
//                        }
                        it.remove();

                    }
                    else if(selectionKey.isReadable()){
                        LOGGER.info("客户端可以读:"+ TimeUtil.longTransferTime(System.currentTimeMillis()));
                        SocketChannel socketChannel= (SocketChannel) selectionKey.channel();
                        while (socketChannel.read(byteBuffer)!=-1){
                            byteBuffer.flip();
                            while(byteBuffer.hasRemaining()){
                                System.out.print((char) byteBuffer.get());
                            }
                            byteBuffer.clear();
                        }
                        it.remove();
                    }
                }


        }






    }
}
