package com.anwei.cloud.nacos.discovery.openfeign.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.anwei.cloud.nacos.discovery.openfeign.service.EchoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Anwei
 * @TODO TODO
 * @date 2019/7/5 15:24
 */
@RestController
public class OpenFeignController {

    /**
     * Feign Service
     */
    @Resource
    EchoService echoService;

    @SentinelResource
    @RequestMapping(value = {"echo/{name}"})
    public Object echo(@PathVariable(required = false) String name) {
        return echoService.echo(name);
    }

    @SentinelResource
    @RequestMapping(value = {"test"})
    public Object test() {
        return echoService.notFound();
    }

    @SentinelResource
    @RequestMapping(value = {"divide"})
    public Object divide(Integer a, Integer b) {
        return echoService.divide(a, b);
    }

    @SentinelResource
    @RequestMapping(value = {"rest"})
    public Object rest() {
        return echoService.notFound();
    }
}
