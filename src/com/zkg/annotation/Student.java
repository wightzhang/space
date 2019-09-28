package com.zkg.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * created by kgzhang 2019/7/8
 */
public class Student {
    @Label("姓名")
    String name;
    @Label("出生日期")
    @Format(pattern="yyyy/MM/dd")
    Date born;
    @Label("分数")
    double score;

    public Student(String name, Date born, double score) {
        this.name = name;
        this.born = born;
        this.score = score;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Student student = new Student("张三",sdf.parse("1990-12-12"), 80.9d);
            System.out.println(SimpleFormatter.format(student));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
