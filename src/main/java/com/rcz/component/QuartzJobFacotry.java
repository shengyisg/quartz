package com.rcz.component;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * Created by fsy on 2018/8/23.
 * 实体化定时任务类时，任务类需要注入系统其他的bean进行服务时
 */

@Component("jobInstance")
public class QuartzJobFacotry extends SpringBeanJobFactory {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

        Object jobInstance = super.createJobInstance(bundle);
        beanFactory.autowireBean(jobInstance);

        return jobInstance;
    }
}
