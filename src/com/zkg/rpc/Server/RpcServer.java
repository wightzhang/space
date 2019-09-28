package com.zkg.rpc.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * created by kgzhang 2018/11/4
 */
public class RpcServer {

    private final ExecutorService executorService
            = Executors.newCachedThreadPool();

    public void publisher(final Object service,int port) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket,service));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null)
            serverSocket.close();
        }
    }
}
