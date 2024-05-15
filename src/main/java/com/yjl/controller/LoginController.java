package com.yjl.controller;

import com.yjl.log.annotation.LoginLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title LoginController
 * @Author yjl
 * @Package com.yjl.controller
 * @Date 2024/5/15 9:49
 * @description aop测试用Login控制层
 */
@RestController
public class LoginController {

    @GetMapping(value = "/username")
    @LoginLog(desc = "验证登录")
    public String username(String username, Integer age) {
        return username+"----------"+age;
    }
}
