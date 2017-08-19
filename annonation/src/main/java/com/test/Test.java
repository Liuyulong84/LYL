package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by $lyl on 2017/8/19.
 */

public class Test {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("Lucy");

        Filter f3 = new Filter();
        f3.setEmail("122@qq.com,zh@189.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }

    private static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        Class c = f.getClass();

        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }

        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //遍历所有的字段
        Field[] aArray = c.getDeclaredFields();
        for (Field field : aArray) {
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;
            }
            //拿到字段名
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            //拿到字段的值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object filedValue = "";
            try {
                Method method = c.getMethod(getMethodName);
                filedValue =  method.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ( filedValue == null ||
                (filedValue instanceof Integer && (Integer)filedValue == 0)){
                continue;
            }
            sb.append(" and ").append(columnName).append("=").append(filedValue);


        }
        return sb.toString();
    }
}
