package com.daojia.datastructures.learn.socket.thread;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/9 14:23.
 */
public class SocketClient {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception{
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        int a = 0;
        while(true){
            if(a%10==0){
                Thread.currentThread().sleep(2000);
            }
            final int b = ++a;
            new Runnable() {
                @Override
                public void run() {
                    try{
                        Socket socket = new Socket(host, port);
                        // 建立连接后获得输出流
                        OutputStream outputStream = socket.getOutputStream();
                        String message = b+"你好  yiwangzhibujian";
                        //首先需要计算得知消息的长度
                        byte[] sendBytes = message.getBytes("UTF-8");
                        outputStream.write(sendBytes);
                        outputStream.flush();
                        outputStream.close();
                        socket.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.run();
        }
       /* //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "第二条消息";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes);
        outputStream.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "the third message!";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes);*/

    }

}
