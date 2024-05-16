package com.yjl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjl.mapper.SysLogMapper;
import com.yjl.model.po.SysLog;
import com.yjl.service.ISysLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Title SysLogServiceImpl
 * @Author yjl
 * @Package com.yjl.service.impl
 * @Date 2024/5/16 11:33
 * @description 系统操作日志记录
 */
@Service
@RequiredArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
    private final SysLogMapper sysLogMapper;

    @Override
    public int insertLog(SysLog entity) {
        return sysLogMapper.insert(entity);
    }
}
