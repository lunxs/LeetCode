package com.lunx.test;

import com.lunx.model.StringModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/10/15
 * @description
 */
public class ReflectDemo {

    private Object setValue(Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getGenericType());

            String methodName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            System.out.println(methodName);

            try {
                Method getMethod = clazz.getMethod("get" + methodName);
                Object obj = getMethod.invoke(bean);
                if (obj == null || "".equals(obj)) {
                    field.set(bean, null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return bean;
    }

    public static void main(String[] args) {
        ReflectDemo reflectDemo = new ReflectDemo();

        StringModel bean = new StringModel();
        bean.setA("");
        Object o = reflectDemo.setValue(bean);

        System.out.println(o);

    }
}
