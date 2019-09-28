package com.zkg.observer.subject;

import com.zkg.observer.core.Event;

import java.lang.reflect.Method;

/*
 * created by kgzhang 2018/10/7
 */
public class Test {
    public static void main(String[] args) {
        Observer observer = new Observer();

        try {
            Method advice = Observer.class.getMethod("advice", Event.class);
            Subject subject = new Subject();
            subject.addListener(SubjectEventType.ON_ADD, observer, advice);
            subject.add();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
