package com.zkg.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * created by kgzhang 2018/11/3
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {
    protected HelloServiceImpl() throws RemoteException {
        //super();
    }


    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello " + name;
    }
}
