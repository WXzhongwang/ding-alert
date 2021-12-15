package com.rany.ops.alert.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhongshengwang
 */
@RestController
public class HealthCheckController {


    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }
}
