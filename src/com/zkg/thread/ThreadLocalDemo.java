package com.zkg.thread;

import javax.xml.ws.spi.http.HttpContext;

/*
 * created by kgzhang 2019/1/6
 */
public class ThreadLocalDemo {

    //private static int num = 0;
    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        protected Integer initialValue() {
            return 0;
        }
    };
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int locnum = num.get();
                System.out.println(Thread.currentThread().getName() + "->" + locnum);
            }, "Thread_" + i).start();
        }
    }
}
