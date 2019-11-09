package com.daojia.datastructures.learn.socket;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/9 10:32.
 */
public class TestSocket {

    public static void main(String[] args) {

        try{
           /* InetAddress address = InetAddress.getLocalHost();
          *//*  address = InetAddress.getByName("www.baidu.com");
            address = InetAddress.getByName("220.181.38.149");*//*
            System.out.println("address:"+address);
            System.out.println(address.getHostName());
            System.out.println(address.getHostAddress());
            System.out.println(address.getAddress());
            System.out.println(address.getCanonicalHostName());

            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
            InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
            System.out.println(socketAddress.getHostName());
            System.out.println(socketAddress2.getAddress());*/

           /* URL u = new URL("http://www.google.cn:80/webhp?canhu=33#aa");
            System.out.println("获取与此url关联的协议的默认端口："+u.getDefaultPort());
            System.out.println("getFile:"+u.getFile());  //端口号后面的内容
            System.out.println("主机名："+u.getHost());  //www.google.cn
            System.out.println("路径："+u.getPath());  //端口号后，参数前的内容
            System.out.println("端口："+u.getPort());  //如果www.google.cn:80则返回80.否则返回-1
            System.out.println("协议："+u.getProtocol());
            System.out.println("参数部分："+u.getQuery());
            System.out.println("锚点："+u.getRef());*/

          /*  URL u1 = new URL("http://www.abc.com/aa/");
            URL u2 = new URL(u1,"2.html");  //相对路径构建url对象
            System.out.println(u2.toString());  //http://www.abc.com/aa/2.html*/

            String a = "a";
            byte[] bytes = a.getBytes("UTF-8");
     /*       System.out.println(1<<2);
            System.out.println(2>>8);
            System.out.println(8>>8);
            System.out.println(-1>>8);
            System.out.println(bytes.length);
            System.out.println(bytes.length>>8);
            System.out.println(2*2*2*2*2*2*2*2);
            System.out.println(2*2*2*2*2*2*2*2 >>8);*/
            System.out.println(-1>>1);
            System.out.println(-1>>2);
            System.out.println(-1<<1);
            System.out.println(-1<<2);
            System.out.println(1>>1);


            //basicSpider();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    static void basicSpider() {
        URL url = null;
        InputStream is = null ;
        BufferedReader br=null;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        try {
            url = new URL("http://www.baidu.com");
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((temp = br.readLine())!=null){
                sb.append(temp);   //这样就可以将网络内容下载到本地机器。然后进行数据分析，建立索引。这也是搜索引擎的第一步。
                System.out.println(temp);
            }
            System.out.println(sb);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
