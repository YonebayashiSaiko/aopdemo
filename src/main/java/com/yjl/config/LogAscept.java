package com.yjl.config;

import com.yjl.log.annotation.LoginLog;
import com.yjl.model.po.SysLog;
import com.yjl.service.ISysLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Title LogAscept
 * @Author yjl
 * @Package com.yjl.config
 * @Date 2024/5/15 17:37
 * @description 日志切面类
 */
@Aspect
@Component
@RequiredArgsConstructor
public class LogAscept {
    private static final Logger log = LoggerFactory.getLogger(LogAscept.class);
//    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(LogAsPect.class);

    private final ISysLogService sysLogService;

    //切入点 指定了自定义注解
    @Pointcut("@annotation(com.yjl.log.annotation.LoginLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();


        result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        //插入日志
        insterLog(proceedingJoinPoint, endTime - beginTime);

        return result;
    }

    private void insterLog(ProceedingJoinPoint proceedingJoinPoint, long costTime) {
        //获取方法签名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获取方法对象
        Method method = methodSignature.getMethod();
        //新建日志对象
        SysLog sysLog = new SysLog();
        //获取方法上的指定注解 尝试拿到注解中的值
        LoginLog annotation = method.getAnnotation(LoginLog.class);
        if (annotation != null) {
            sysLog.setUser_action(annotation.value());
        }
        //获取到的是方法所在类的名称
        //String declaringTypeName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        //获取到的是正在执行的方法所属的对象的类的名称。
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = methodSignature.getName();
        // 请求的方法参数值
        String args = Arrays.toString(proceedingJoinPoint.getArgs());
        //todo 获取当前用户的方法暂挂 yjl项目想要使用springsecurity框架来进行安全管理
        Long userid = 1L;
        sysLog.setUser_id(userid);
        LocalDateTime time = LocalDateTime.now();
        sysLog.setCreate_time(time);
        log.info("当前登陆人：{},类名:{},方法名:{},参数：{},执行时间：{}", userid, className, methodName, args, time);
        sysLogService.insterLog(sysLog);
    }
}
