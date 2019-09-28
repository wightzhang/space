package com.zkg.protocol;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * created by kgzhang 2018/11/2
 */
public class ClientSocketDemo {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1",8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
