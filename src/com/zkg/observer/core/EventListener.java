package com.zkg.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * created by kgzhang 2018/10/7
 */
public class EventListener {

    private Map<Enum, Event> events = new HashMap<>();

    public void addListener(Enum eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event e) {
        e.setSource(this);

        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));

    }
}
