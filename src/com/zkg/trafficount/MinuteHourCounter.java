package com.zkg.trafficount;

import java.time.LocalDateTime;

/*
 * created by kgzhang 2019/3/21
 */
public interface MinuteHourCounter {
    //增加流量
    //void add(int count);

    void add(int count,LocalDateTime time);

    //统计过去一分钟的流量
    int minuteCount();
    //统计过去一小时的流量
    int hourCount();
}
