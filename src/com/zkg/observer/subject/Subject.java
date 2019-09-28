package com.zkg.observer.subject;

import com.zkg.observer.core.EventListener;

/*
 * created by kgzhang 2018/10/7
 */
public class Subject extends EventListener {

    public void add(){
        System.out.println("添加");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("删除");
    }

}
