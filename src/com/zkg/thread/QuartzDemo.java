package com.zkg.thread;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/*
 * created by kgzhang 2019/1/26
 */
public class QuartzDemo {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        JobDetail job = newJob(MyJob.class)
                .withIdentity("myJob", "group2") // name "myJob", group "group1"
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .withRepeatCount(5))
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.start();
    }
}
