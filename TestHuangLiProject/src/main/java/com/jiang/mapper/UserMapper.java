package com.jiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiang.vo.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> getUserList(Page<User> page, String empName, String deptName, String empDegreeName);
}
