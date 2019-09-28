package com.zkg.rpc.Server;

import com.zkg.rpc.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/*
 * created by kgzhang 2018/11/4
 */
public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Object service; //发布的服务 ,里面有所有接口方法

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {//处理请求
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request =  (RpcRequest) inputStream.readObject();
            Object result =  invoke(request); //服务端执行结果

            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request){
        Object[] args = request.getParameters();

        Class<?>[] types = new Class[args.length];
        for(int i = 0;i<args.length;i++){
            types[i] = args[i].getClass();
        }

        try {
            Method method = service.getClass().getMethod(request.getMethodName(),types);
            return method.invoke(service,args);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
