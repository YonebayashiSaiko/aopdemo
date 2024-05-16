package com.yjl.service.impl;

import com.yjl.mapper.SysLogMapper;
import com.yjl.model.po.SysLog;
import com.yjl.service.ISysLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Title SysLogServiceImpl
 * @Author yjl
 * @Package com.yjl.service.impl
 * @Date 2024/5/15 17:11
 * @description
 */
@Service("sysLogService")
@RequiredArgsConstructor
public class SysLogServiceImpl implements ISysLogService {

    private final SysLogMapper sysLogMapper;

    @Override
    public int insterLog(SysLog entity) {
        return sysLogMapper.insert(entity);
    }
}
