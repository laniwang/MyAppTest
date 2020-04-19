package com.example.myapplication;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static final String TAG="SimpleServer";

    public static void main(String[] args) throws IOException {
        Log.e(TAG,"Server Main-->");
        // 创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket( 9901 );
        // 采用循环不断接受来自客户端的请求
        while (true) {
            // 每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            OutputStream os = s.getOutputStream(); //服务端向client发数据流 outPut
            os.write( " 来追我呀！如果你追到我，我就跟你一起走可持续发展的中国特色社会主义道路！！！\n"
                    .getBytes( "utf-8" ) );
            Log.e(TAG,"server print------------------");
            // 关闭输出流，关闭Socket
            os.close();
            s.close();
        }
    }
}