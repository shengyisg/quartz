package com.rcz.service;


import com.rcz.entity.JobAndTrigger;
import com.github.pagehelper.PageInfo;
import com.rcz.entity.JobDetail;

public interface IJobAndTriggerService {
	public PageInfo<JobDetail> getJobDetails(int pageNum, int pageSize);

	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
