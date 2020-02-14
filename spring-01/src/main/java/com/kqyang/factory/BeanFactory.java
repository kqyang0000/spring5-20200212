package com.kqyang.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;
    /**
     * 定义容器
     */
    private static Map<String, Object> beans;

    static {
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
            /**实例化容器*/
            beans = new HashMap<String, Object>(16);
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String valuePath = props.getProperty(key);
                Object bean = Class.forName(valuePath).newInstance();
                beans.put(key, bean);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化异常");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /*public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
