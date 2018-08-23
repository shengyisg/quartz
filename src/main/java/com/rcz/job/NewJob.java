package com.rcz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rcz.component.JobComponent;
import com.rcz.entity.JobAndTrigger;
import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class NewJob extends QuartzJobBean{

    @Autowired
    private JobComponent jobComponent;

    private static Logger _log = LoggerFactory.getLogger(NewJob.class);  
     
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String jobName = jobExecutionContext.getMergedJobDataMap().getString("jobName");
        String jobGroup = jobExecutionContext.getMergedJobDataMap().getString("jobName");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(new Date());

        jobComponent.ww();

        _log.error(jobName +"New Job执行时间: " + dateString);
    }
}  