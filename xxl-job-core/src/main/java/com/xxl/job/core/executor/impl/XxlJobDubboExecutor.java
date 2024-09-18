package com.xxl.job.core.executor.impl;


import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.handler.annotation.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class XxlJobDubboExecutor extends XxlJobExecutor implements ApplicationContextAware, SmartInitializingSingleton, DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(XxlJobDubboExecutor.class);


    // ---------------------- applicationContext ----------------------
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        XxlJobDubboExecutor.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    @Override
    public void afterSingletonsInstantiated() {
        registerMethod(getApplicationContext());
    }

    private void registerMethod(ApplicationContext context) {
        if (context == null) {
            return;
        }
        // init job handler from method
        String[] beanDefinitionNames = context.getBeanNamesForType(Object.class, false, true);
        for (String beanDefinitionName : beanDefinitionNames) {
            // get bean
            Object bean = null;
            Job onBean = context.findAnnotationOnBean(beanDefinitionName, Job.class);
            if (onBean != null) {
                onBean.getClass();
            }

        }

    }

}
