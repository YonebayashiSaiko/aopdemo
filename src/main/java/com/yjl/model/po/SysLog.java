package com.yjl.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @Title SysLog
 * @Author yjl
 * @Package com.yjl.model.po
 * @Date 2024/5/15 16:14
 * @description 日志实体类
 */
@Data
@TableName("sys_log")
public class SysLog {
    @TableId
    //主键id
    private Long id;
    //用户id
    private Long user_id;
    //用户动作
    private String user_action;
    //操作记录时间
    private LocalDateTime create_time;
}
