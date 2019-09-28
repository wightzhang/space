package com.zkg.rmi;

import javax.naming.Name;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*
 * created by kgzhang 2018/11/3
 */
public class Server {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        IHelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://127.0.0.1/Hello",helloService);
        System.out.println("服务启动成功");
    }
}
