package com.rcz;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerConfig {

    /**
     *  <bean id = "SchedulerFactory" class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
     *      <property name="dataSource" ref="dataSource"></property>//如果quartz.properties没有配置具体的数据库org.quartz.jobStore.dataSource=dataSource
     *      <property name="configLocation" value="classpath:/quartz.properties"></property>//也可以直接配置数据源，如本案例
     *  </bean>
     *
     *
     */


    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
  
    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
       return new QuartzInitializerListener();
    }
    
    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

}
