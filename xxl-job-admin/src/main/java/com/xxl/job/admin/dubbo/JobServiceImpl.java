package com.xxl.job.admin.dubbo;

import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.util.JacksonUtil;
import com.xxl.job.admin.service.JobService;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private XxlJobService xxlJobService;

    @Override
    public void addJob(String json) {
        XxlJobInfo xxlJobInfo = JacksonUtil.readValue(json, XxlJobInfo.class);
        ReturnT<String> add = xxlJobService.add(xxlJobInfo);
    }
}
