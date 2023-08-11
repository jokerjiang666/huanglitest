package com.jiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiang.entity.CommonResult;
import com.jiang.vo.AdminUser;

public interface ILoginService extends IService<AdminUser> {

    CommonResult loginUser(String username,String password);
}
