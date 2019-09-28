package com.zkg.thread;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * created by kgzhang 2018/12/18
 */
public class MyThread extends Thread {
    public synchronized static void doSomething() {
        while (true) {
            //do something
        }
    }

    @Override
    public void run() {
        doSomething();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new MyThread();
        thread2.start();

        Thread.sleep(1000);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

        thread2.interrupt();
        System.out.println(thread2.isInterrupted());
        System.out.println(thread2.getState());

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key", "value");
    }
}
