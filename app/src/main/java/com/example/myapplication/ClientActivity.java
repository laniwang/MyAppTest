package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientActivity extends AppCompatActivity {

    public static final String TAG="ClientActivity";

    private DataOutputStream out = null;

    EditText show;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        show = (EditText) findViewById(R.id.et_message );
//        Intent intent=new Intent( ClientActivity.this, )

        new Thread()
        {

            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(10000);
                    Log.e(TAG,"client Run-->");
                    // 建立连接到远程服务器的Socket
                    Socket socket = new Socket("192.168.0.103", 8083);  // ①
                    // 将Socket对应的输入流包装成BufferedReader
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));//读取来自服务端的数据
                    String data = "HI LAIN is here";
                    writeStr( data,socket);
                    // 进行普通I/O操作
                    String line = br.readLine();
                    show.setText("来自服务器的数据：" + line);
                    // 关闭输入流、socket
                    br.close();
                    socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    /**
     * 向SOCKET中写入数据
     * @return
     */
    public boolean writeStr(String message,Socket socket) {
//       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        //DataOutputStream dataWriter = new DataOutputStream(outputStream);
//        //dataWriter has more API for writing data.
//       outputStream.write(data.getBytes());
//       outputStream.flush();

        Log.e(TAG,"werite message");
        try {
            DataOutputStream  out = new DataOutputStream(socket.getOutputStream());//获得SOCKET输出流:outputstream
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(socket.isConnected()==false)
            return false;
        byte[] request=null;

        try {
            request = message.getBytes();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            out.write(request);//bytes流输出
            out.flush(); //冲到服务端去
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
