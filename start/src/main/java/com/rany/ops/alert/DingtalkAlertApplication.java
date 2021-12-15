package com.rany.ops.alert;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhongshengwang
 */
@EnableDubbo
@SpringBootApplication
public class DingtalkAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingtalkAlertApplication.class, args);
    }

}
