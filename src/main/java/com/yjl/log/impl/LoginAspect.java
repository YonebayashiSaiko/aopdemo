package com.yjl.log.impl;

import com.yjl.log.annotation.LoginLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Title LoginAspect
 * @Author yjl
 * @Package com.yjl.log.impl
 * @Date 2024/5/15 11:20
 * @description 登录log切面类
 */
@Aspect
@Component
public class LoginAspect {
    @Pointcut(value = "@annotation(com.yjl.log.annotation.LoginLog)")
    public void access() {
    }

    @Before("access()")
    public void login() {
        System.out.println("开始验证用户是否登录...");
    }

    @Around("@annotation(loginLog)")
    public Object loginAround(ProceedingJoinPoint proceedingJoinPoint, LoginLog loginLog) {

        System.out.println("注解中的值 : " + loginLog.desc());
        try {
            // 检验是否登录 true 已经登录  false 未登录
            Boolean flag = false;
            if (flag == true) {
                return "登录成功";
            } else {
                return "未登录";
            }
        } catch (Throwable throwable) {
            return null;
        }
    }
}
