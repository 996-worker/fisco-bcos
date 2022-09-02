package com.post.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
* @Title: 获取spring上下问工具  
* @Description: TODO(描述)
* @author: 雷大鹏  
* @date: 2020-05-10 10:19:51
 */
@Component
public class CtxUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public CtxUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CtxUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext != null?applicationContext.getBean(beanName):null;
    }
}
