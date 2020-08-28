package com.springcloud.netty.server;

import com.springcloud.common.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NioServerClient {
    private static Logger LOGGER= LoggerFactory.getLogger(NioServerClient.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        List<SocketChannel>  socketChannels=new ArrayList<>();




        while (true) {
            LOGGER.info("正在等待客户端请求连接...:{}", TimeUtil.longTransferTime(System.currentTimeMillis()));

            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                LOGGER.info("正在等待客户端请求连接...");
                Thread.sleep(5000);
            } else {
                socketChannels.add(socketChannel);
            }


            for(SocketChannel socket:socketChannels){
                socket.configureBlocking(false);
                int effective = socket.read(byteBuffer);
                if(effective!=0) {
                    String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
//                    byteBuffer.flip();
                    byteBuffer.clear();
                    LOGGER.info("收到客户端消息:"+content);
                }else{
                    LOGGER.info("当前未收到客户端消息,数据正在准备中");
                }
            }
        }


    }
}
