package com.rcz.dao;

import com.rcz.entity.JobAndTrigger;
import com.rcz.entity.JobDetail;

import java.util.List;

/**
 * Created by fsy on 2018/2/12 0012.
 */
public interface JobDetailMap {
    public List<JobDetail> queryJobDetails();
}
