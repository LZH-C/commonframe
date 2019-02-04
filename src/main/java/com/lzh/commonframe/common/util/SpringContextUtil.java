package com.lzh.commonframe.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;


public class SpringContextUtil extends ApplicationObjectSupport {
    static  SpringContextUtil springContextUtil=new SpringContextUtil();

    public static Object getBean(String name) throws BeansException {
        try {
            return springContextUtil.getApplicationContext().getBean(name);
        } catch (Exception e) {
            throw new RuntimeException("获取的Bean不存在！");
        }
    }

    public static <T> T getBean(String name, Class<T> requiredType)
            throws BeansException {
        return springContextUtil.getApplicationContext().getBean(name, requiredType);
    }

}
