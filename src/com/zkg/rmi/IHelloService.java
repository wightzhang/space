package com.zkg.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * created by kgzhang 2018/11/3
 */
public interface IHelloService extends Remote {

    String sayHello(String name)  throws RemoteException;
}
