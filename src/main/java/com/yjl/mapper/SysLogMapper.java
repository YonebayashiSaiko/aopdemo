package com.yjl.mapper;

/**
 * @Title SysLogMapper
 * @Author yjl
 * @Package com.yjl.mapper
 * @Date 2024/5/15 17:25
 * @description
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjl.model.po.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
