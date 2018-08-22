package com.rcz.component;

import org.springframework.stereotype.Component;

/**
 * Created by fsy on 2018/8/22.
 */
@Component("jobComponent")
public class JobComponent {

    public String ww(){
        System.out.println("进入了组件");
        return "进入了组件";
    }
}
