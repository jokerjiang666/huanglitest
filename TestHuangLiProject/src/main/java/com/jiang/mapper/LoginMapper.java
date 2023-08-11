package com.jiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiang.vo.AdminUser;
import com.jiang.vo.User;
import org.mapstruct.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<AdminUser> {
}
