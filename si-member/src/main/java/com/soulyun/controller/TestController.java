package com.soulyun.controller;

import com.soulyun.common.ResponseInfo;
import com.soulyun.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(("/test"))
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/hello")
    public ResponseInfo<String> hello() {
        return ResponseInfo.success("Hello world!");
    }

    @GetMapping("/error")
    public ResponseInfo<String> error() {
        testService.error();
        return ResponseInfo.success("Hello error!");
    }


}
