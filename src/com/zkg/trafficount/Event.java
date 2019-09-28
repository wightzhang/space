package com.zkg.trafficount;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/*
 * created by kgzhang 2019/3/21
 */
public class Event {
    private int count;
    private LocalDateTime time;
    public Event(int count,LocalDateTime time){
        this.count = count;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }


}
