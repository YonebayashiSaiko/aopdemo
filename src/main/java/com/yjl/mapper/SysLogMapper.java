package com.yjl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjl.model.po.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @Title SysLogMapper
 * @Author yjl
 * @Package com.yjl.mapper
 * @Date 2024/5/16 11:31
 * @description 系统日志操作
 */
@MapperScan
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
}
