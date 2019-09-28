package com.zkg.proxy.jdk;

import com.zkg.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * created by kgzhang 2019/3/10
 */
public class JDKMeipo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，开始找对象");
        Object invoke = method.invoke(this.target, args);
        System.out.println("我是媒婆，结束找对象");
        return invoke;
    }
}
