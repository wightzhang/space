package com.zkg.rpc.client;

import com.zkg.rpc.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * created by kgzhang 2018/11/4
 */
public class TCPTransport {
    private String host;
    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("创建一个新的连接");
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("创建连接失败");
        }
    }

    public Object send(RpcRequest request) throws IOException {
        Socket socket = null;
        try {
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    socket.getOutputStream());
            outputStream.writeObject(request);

            ObjectInputStream inputStream = new ObjectInputStream(
                    socket.getInputStream());
            Object result = inputStream.readObject();
            inputStream.close();
            outputStream.close();
            socket.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("发起远程调用异常", e);
        }
    }
}
