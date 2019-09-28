package com.zkg.annotation;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
 * created by kgzhang 2019/7/8
 */
public class SimpleFormatter {
    public static String format(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            for (Field f : cls.getDeclaredFields()) {
                Label label = f.getAnnotation(Label.class);
                String name = label != null ? label.value() : f.getName();
                Object value = f.get(obj);
                if (value != null && f.getType() == Date.class) {
                    value = formatDate(f, value);
                }
                sb.append(name).append(":").append(value).append("\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object formatDate(Field f, Object value) {
        Format format = f.getAnnotation(Format.class);
        if (format != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return sdf.format(value);
        }
        return value;
    }
}
