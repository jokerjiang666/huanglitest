package com.jiang.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiang.entity.CommonResult;
import com.jiang.service.IUserService;
import com.jiang.util.ExcelUtil;
import com.jiang.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Api("员工管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 查询员工信息
     */
    @ApiOperation("查询员工信息")
    @ApiImplicitParam(name = "id",value = "员工表对应id",dataType = "int",paramType = "query")
    @GetMapping("getUserInfo")
    public CommonResult getUserInfo(Integer id){
        try{
            return CommonResult.success("操作成功",userService.getById(id));
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("操作失败",null);
        }
    }

    /**
     * 查询全部员工信息
     */
    @ApiOperation("查询全部员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "数量", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "empName", value = "员工姓名", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "deptName", value = "部门名称", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "empDegreeName", value = "学历", dataType = "string",paramType = "query")
    })
    @GetMapping("/selectAll")
    public CommonResult selectAll(
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
            @RequestParam(value = "empName",required = false) String empName,
            @RequestParam(value = "deptName",required = false) String deptName,
            @RequestParam(value = "empDegreeName",required = false) String empDegreeName
    ){
            IPage userList = userService.getUserList(pageNum, pageSize, empName, deptName, empDegreeName);
            if(userList != null){
                return CommonResult.success("操作成功",userList);
            }else{
                return CommonResult.failed("操作失败",null);
            }
    }

    /**
     * 新增或更新员工信息
     */
    @ApiOperation("新增或更新员工信息")
    @ApiImplicitParam(name = "user",value = "员工对象",dataType = "json")
    @PostMapping("/updateUser")
    public CommonResult updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }

    /**
     * 根据id删除员工信息
     */
    @ApiOperation("根据id删除员工信息")
    @ApiImplicitParam(name = "userId",value = "员工id",dataType = "int",paramType = "query")
    @DeleteMapping("/delete")
    public CommonResult deleteById(Integer userId) {
        try{
            userService.removeById(userId);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("删除失败",null);
        }
        return CommonResult.success("删除成功",null);
    }

    /**
     * 导出员工数据
     */
    @ApiOperation("导出员工数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "数量", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "empName", value = "员工姓名", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "deptName", value = "部门名称", dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "empDegreeName", value = "学历", dataType = "string",paramType = "query")
    })
    @GetMapping("/exportUserData")
    public CommonResult exportUserData(
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
            @RequestParam(value = "empName",required = false) String empName,
            @RequestParam(value = "deptName",required = false) String deptName,
            @RequestParam(value = "empDegreeName",required = false) String empDegreeName,
            HttpServletResponse response
    ) {
        try{
            IPage userList = userService.getUserList(pageNum, pageSize, empName, deptName, empDegreeName);
            List userRecords = userList.getRecords();

            String fileName = "员工信息"+".xls";
            ExcelUtil.exportExcel(userRecords, User.class, fileName, true, response);

            return CommonResult.success("导出成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.success("导出失败",null);
        }
    }
}
