package com.yjl.service;

import com.yjl.model.po.SysLog;

/**
 * @Title ISysLogService
 * @Author yjl
 * @Package com.yjl.service
 * @Date 2024/5/15 16:09
 * @description 日志操作
 */
public interface ISysLogService {
    int insterLog(SysLog entity);
}
