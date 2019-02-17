/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/19
  Time: 18:17
  To change this template use File | Settings | File Templates.
*/
package com.drc.utils;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LogUtil {
    //定义一个全局的记录器，通过LoggerFactory获取
    private static Boolean isDebug=true;
   /**
     * @param str
     */
    public static void info(String str){
        Pair<Logger, String> p = getLogger();
        p.getKey().info(p.getValue() + " *********=>" + str);
    }
    public static void error(String str){
        Pair<Logger, String> p = getLogger();
        p.getKey().error(p.getValue()+"*********=>"+str);
    }

    public static void debug(String str){
        if(isDebug) {
            Pair<Logger, String> p = getLogger();
            p.getKey().debug(p.getValue()+"*********=>" + str);
        }
    }

    public static void warn(String str){
        Pair<Logger, String> p = getLogger();
        p.getKey().warn(p.getValue()+"*********=>"+str);
 }

    private static Map<Class, Logger> caches = new HashMap<>();
    private static Pair<Logger, String> getLogger() {
        StackTraceElement caller = findCaller();
        String className = caller.getClassName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //类文件 ,函数  行数 信息
        String s = caller.getClassName() + "." + caller.getMethodName() + "("
                + caller.getFileName() + ":" + caller.getLineNumber() + ")";
        if (caches.containsKey(clazz)) {
            return new Pair<>(caches.get(clazz), s);
        }
        Logger l = LoggerFactory.getLogger(clazz);
        caches.put(clazz, l);
        return new Pair<>(l, s);
    }
    private static StackTraceElement findCaller() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();

        // 最原始被调用的堆栈信息
        StackTraceElement caller = null;

        // 日志类名称

        String logClassName = LogUtil.class.getName();
        // 循环遍历到日志类标识

        int i = 0;
        for (int len = callStack.length; i < len; i++) {
            if (logClassName.equals(callStack[i].getClassName())) {
                break;
            }
        }
        //是的没有错,这是一个magic number！想知道为什么？开启你的堆栈，来寻找我的宝藏吧！
        caller = callStack[i + 3];
        return caller;
    }

}
