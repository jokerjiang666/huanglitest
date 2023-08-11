package com.jiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiang.entity.CommonResult;
import com.jiang.mapper.LoginMapper;
import com.jiang.service.ILoginService;
import com.jiang.vo.AdminUser;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, AdminUser> implements ILoginService {

    @Override
    public CommonResult loginUser(String username,String password) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdminUser::getUsername,username).eq(AdminUser::getPassword, password);
        AdminUser adminUser1 = this.getOne(queryWrapper);
        if(adminUser1 != null){
            return CommonResult.success("登陆成功",adminUser1);
        }else{
            return CommonResult.success("登陆失败,用户名或密码错误",adminUser1);
        }
    }
}
