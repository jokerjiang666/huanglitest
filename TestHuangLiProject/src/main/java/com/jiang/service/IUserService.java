package com.jiang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiang.entity.CommonResult;
import com.jiang.vo.User;

public interface IUserService extends IService<User> {
    IPage getUserList(int pageNum, int pageSize, String empName, String deptName, String empDegreeName);

    CommonResult updateUser(User user);

}
