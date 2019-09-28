package com.zkg.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * created by kgzhang 2018/11/2
 */
public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader=null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(bufferedReader!=null){
                bufferedReader.close();
            }

            if(serverSocket!=null){
                serverSocket.close();
            }
        }

    }
}
