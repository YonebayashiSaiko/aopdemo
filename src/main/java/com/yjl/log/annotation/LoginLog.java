package com.yjl.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title LoginLog
 * @Author yjl
 * @Package com.yjl.log.annotation
 * @Date 2024/5/15 11:16
 * @description 自定义注解 用来获取请求方法是否需要记录日志
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLog {
    String value() default "";
}
