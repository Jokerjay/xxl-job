package com.xxl.job.core.handler.annotation;


import org.apache.dubbo.config.annotation.DubboService;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@DubboService
public @interface Job {
}
