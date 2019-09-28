package com.zkg.proxy.dbroute.db;

/*
 * created by kgzhang 2019/3/10
 */
public class DynamicDataSourceEntity {


    private final static ThreadLocal<String> local =
            new ThreadLocal<String>();

    private DynamicDataSourceEntity() {
    }

    public static void restore() {
        local.set(null);
    }

    public static String get() {
        return local.get();
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }
}
