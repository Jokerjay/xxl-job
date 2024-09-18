package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.admin.service.IJob;
import com.xxl.job.core.handler.annotation.Job;

@Job
public class SampleXxlJobImpl implements IJob {
    @Override
    public void work() {
        System.out.println("test1111");
    }
}
