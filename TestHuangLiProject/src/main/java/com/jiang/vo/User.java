package com.jiang.vo;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

//职工表
@Data
@TableName("user")
public class User {
    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @Excel(name = "员工姓名", width = 20)
    @ApiModelProperty(value = "员工姓名")
    @TableField("emp_name")
    private String empName;

    @Excel(name = "性别", width = 20)
    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @Excel(name = "年龄", width = 20)
    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @Excel(name = "部门名称", width = 20)
    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @Excel(name = "学历", width = 20)
    @ApiModelProperty(value = "学历")
    @TableField("emp_degree_name")
    private String empDegreeName;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time", fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;
}
