package com.zkg.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * created by kgzhang 2018/11/3
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHelloService helloService = (IHelloService) Naming.lookup("rmi://127.0.0.1/Hello");
        System.out.println(helloService.sayHello("kgzhang"));
    }
}
