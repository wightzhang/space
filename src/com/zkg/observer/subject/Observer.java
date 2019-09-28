package com.zkg.observer.subject;

import com.zkg.observer.core.Event;

/*
 * created by kgzhang 2018/10/7
 */
public class Observer {

    public void advice(Event e){
        System.out.println("添加事件被触发，记录日志");
        System.out.println(e);
    }
}
