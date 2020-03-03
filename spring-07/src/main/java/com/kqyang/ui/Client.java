package com.kqyang.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    /**
     * ApplicationContext：
     *      AnnotationConfigApplicationContext
     *      ClassPathXmlApplicationContext
     *      FileSystemXmlApplicationContext
     * <p>
     * 两个核心容器引发的问题：
     *      单例
     *      ApplicationContext:
     *          在构造核心容器时，创建对象采用立即加载的方式。也即是说，读取完配置文件后，就马上创建配置文件中的对象
     *      多例
     *      BeanFactory:
     *          在构造核心容器时，创建对象采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     *
     * @param args
     */
    /*public static void main(String[] args) {

    }*/
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 数据库表字段驼峰转换
     *
     * @param sourceColumnName
     * @return
     */
    private static String changeToCamel(String sourceColumnName) {
        sourceColumnName = sourceColumnName.toLowerCase();
        Matcher matcher = linePattern.matcher(sourceColumnName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeToCamel("aabbCc"));
    }
}
