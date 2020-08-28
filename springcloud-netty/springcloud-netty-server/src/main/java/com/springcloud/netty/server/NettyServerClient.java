package com.springcloud.netty.server;

import com.springcloud.common.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NettyServerClient {
    private static Logger LOGGER= LoggerFactory.getLogger(NettyServerClient.class);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        while (!Thread.currentThread().isInterrupted()){
            Long begin=System.currentTimeMillis();
            LOGGER.info("accept期间是阻塞的,当前时间:"+ TimeUtil.longTransferTime(begin));
            Socket socket= serverSocket.accept();
            LOGGER.info("accept成功,间隔为:{}s",TimeUtil.interval(begin,System.currentTimeMillis()));

            Long readBgin=System.currentTimeMillis();
            LOGGER.info("read期间是阻塞的,当前时间:"+ TimeUtil.longTransferTime(readBgin));
            InputStream inputStream=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String content;
            while ((content=reader.readLine())!=null){
                LOGGER.info("当前读取到的内容:"+content);
            }
            LOGGER.info("read结束,间隔为:{}s",TimeUtil.interval(readBgin,System.currentTimeMillis()));

        }
    }
}
