package com.rcz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rcz.entity.JobAndTrigger;
import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class NewJob implements BaseJob {  


    private static Logger _log = LoggerFactory.getLogger(NewJob.class);  
     
    public NewJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {
        String jobName = context.getMergedJobDataMap().getString("jobName");
        String jobGroup = context.getMergedJobDataMap().getString("jobName");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(new Date());

        _log.error(jobName +"New Job执行时间: " + dateString);
          
    }  
}  