package com.rcz.service.impl;

import java.util.List;

import com.rcz.dao.JobAndTriggerMapper;
import com.rcz.dao.JobDetailMap;
import com.rcz.entity.JobAndTrigger;
import com.rcz.entity.JobDetail;
import com.rcz.service.IJobAndTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;
	
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
		PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
		return page;
	}


	@Autowired
	private JobDetailMap jobdetailmap;
	public PageInfo<JobDetail> getJobDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobDetail> list = jobdetailmap.queryJobDetails();
		PageInfo<JobDetail> page = new PageInfo<JobDetail>(list);

		return page;
	}
}