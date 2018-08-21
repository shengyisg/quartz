package com.rcz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rcz.entity.JobAndTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;   

  
public class HelloJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
     
    public HelloJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        JobAndTrigger jobAndTrigger = (JobAndTrigger)context.getMergedJobDataMap().get("jobAndTrigger");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(new Date());

        _log.error(jobAndTrigger.getJOB_NAME()+"Hello Job执行时间: " + dateString);
          
    }  
}  
