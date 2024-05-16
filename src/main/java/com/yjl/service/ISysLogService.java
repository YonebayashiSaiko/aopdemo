package com.yjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yjl.model.po.SysLog;

/**
 * @Title ISysLogService
 * @Author yjl
 * @Package com.yjl.service
 * @Date 2024/5/16 11:32
 * @description 系统日志操作
 */

public interface ISysLogService extends IService<SysLog> {
    int insertLog(SysLog entity);
}
