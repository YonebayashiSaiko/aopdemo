package com.yjl.log.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * @Title AsceptTest
 * @Author yjl
 * @Package com.yjl.log.impl
 * @Date 2024/5/15 9:56
 * @description 日志切面
 */
@Aspect
@Component
public class AsceptTest {
    /**
     * 切入点
     * 定义切点，这里使用的是条件表达式；
     * 规则 ：* com.yjl.controller.*.*(..))
     * com.yjl.controller 指定包下
     * 第一个.*代表包下任意类
     * 第二个.*代表包下任意类中任意方法
     * (..)代表任何个参数数目
     * 所以规则为指定包下任意类的任意个参数的任意方法
     */
//    @Pointcut("execution(* com.yjl.controller.*.*(..)))")
    @Pointcut("execution(* com.yjl.service.*.*(..)))")
    public void loginLog() {
    }

    //前置通知 前置增强，就是在目标方法执行之前执行
    @Before("loginLog()")
    public void Loginbefore(JoinPoint joinPoint) {
        // 我们从请求的上下文中获取request，记录请求的内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取request对象
        HttpServletRequest request = requestAttributes.getRequest();
        /**
         * 这个对象中包含了很多信息
         * 下例：
         * */
        //       本次请求的请求路径
        String requestURI = request.getRequestURI();
        //       本次请求的请求方式
        String requestMethod = request.getMethod();
        /**
         * 除此之外有一些参数需要从切入点对象中获取 joinPoint
         */
        //       本次请求的方法名
        String methodName = joinPoint.getSignature().getName();
        //       本次请求的类路径
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        //       本次请求的参数
        String parameter = Arrays.toString(joinPoint.getArgs());
    }

    //后置增强，方法退出时执行；
    @AfterReturning(returning = "object", pointcut = "loginLog()")
    public void doAfterReturning(Object object) {
        //方法的返回值
        System.out.println(object);
    }

    //异常通知 有异常时该方法执行；
    @AfterThrowing(throwing = "e", pointcut = "loginLog()")
    public void throwsExecute(JoinPoint joinPoint, Exception e) {
        System.out.println(e.getMessage());
    }

    //最终增强，无论什么情况都会执行；
    @After("loginLog()")
    public void afterInform() {
        System.out.println("后置通知结束");
    }
    //环绕增强
    @Around("loginLog()")
    public Object surroundInform(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知开始");

        try {
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed，结果是 ：" + proceed);
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
