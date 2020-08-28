package com.springcloud.netty.client;

import com.springcloud.common.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NettyClientServer {
    private static Logger LOGGER= LoggerFactory.getLogger(NettyClientServer.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        String data1="这是传输的数据第一份数据===";
        String data2="这是传输的数据第二份数据";

        Long beginConnect=System.currentTimeMillis();

        LOGGER.info("建立请求连接开始:"+TimeUtil.longTransferTime(beginConnect));
        Socket socket=new Socket(InetAddress.getLocalHost(),8080);
//        LOGGER.info("建立请求连接结束,耗时:{}s",TimeUtil.interval(beginConnect,System.currentTimeMillis()));
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String line;
        while (!"end".equals(line=sc.next())){
            sb.append(line);
        }
        socket.getOutputStream().write(sb.toString().getBytes());
        socket.close();
        sc.close();



//        OutputStream outputStream=socket.getOutputStream();
//        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
//
//        Long begin=System.currentTimeMillis();
//        LOGGER.info("写数据是阻塞的,当前时间:"+ TimeUtil.longTransferTime(begin));
//        writer.write(data1);
//        Thread.sleep(5000);
//        writer.write(data2);
//        writer.flush();
//        LOGGER.info("耗时:"+TimeUtil.interval(begin,System.currentTimeMillis()));
//        outputStream.close();
//        socket.close();


    }
}
