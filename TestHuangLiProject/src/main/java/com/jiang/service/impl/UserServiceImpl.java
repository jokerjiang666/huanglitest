package com.jiang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiang.entity.CommonResult;
import com.jiang.mapper.UserMapper;
import com.jiang.service.IUserService;
import com.jiang.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage getUserList(int pageNum, int pageSize, String empName, String deptName, String empDegreeName) {

        try{
            Page<User> page = new Page<>(pageNum,pageSize,true);

            IPage<User> userIPage = userMapper.getUserList(page, empName, deptName,empDegreeName);

            return userIPage;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CommonResult updateUser(User user) {
        if(user != null){
            if(user.getUserId() != null){
                LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
                queryWrapper.eq(User::getEmpName,user.getEmpName()).ne(User::getUserId,user.getUserId());
                int count = this.count(queryWrapper);
                if(count > 1){
                    //返回重名
                    CommonResult.failed("职工姓名重复",null);
                }else{
                    try{
                        this.saveOrUpdate(user);
                    }catch (Exception e){
                        e.printStackTrace();
                        CommonResult.failed("修改失败",null);
                    }
                }
                return CommonResult.success("修改成功",null);
            }else{
                this.save(user);
                return CommonResult.success("添加成功",null);
            }
        }else{
            return CommonResult.success("职工数据有误",null);
        }
    }



}
