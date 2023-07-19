package com.xiafish.controller;

import com.xiafish.pojo.*;
import com.xiafish.service.AdminService;
import com.xiafish.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("admin/user")
    public Result findAllUser(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer pageSize, User user)
    {
        log.info("管理员查询用户条件：page={},pageSize={},User筛选条件={}",page,pageSize,user.toString());
        PageBean pageBean=adminService.findAllUser(page,pageSize,user);
        return Result.success(pageBean);
    }
    @DeleteMapping("admin/user/{ids}")
    public Result deleteUser(@PathVariable List<Integer> ids)
    {
        log.info("管理员删除用户，id：{}",ids);
        adminService.deleteUser(ids);
        return Result.success();
    }
    @PostMapping("/admin/add")
    public Result addUser(@RequestBody User user)
    {
        log.info("管理员新建用户：{}",user.toString());
        if(!(user.getUserEmail().isEmpty())&&!(ValidationUtils.isValidEmail(user.getUserEmail())))
            return Result.error("Invalid email format");
        if(!(user.getUserPhoneNum().isEmpty())&&!(ValidationUtils.isValidPhoneNumber(user.getUserPhoneNum())))
            return Result.error("Invalid phone number format");
        adminService.addUser(user);
        return Result.success();
    }

    @PatchMapping("admin/update")
    public Result updateUser(@RequestBody User user)
    {
        log.info("管理员更改用户信息：{}",user.toString());
        if(!(user.getUserEmail().isEmpty())&&!(ValidationUtils.isValidEmail(user.getUserEmail())))
            return Result.error("Invalid email format");
        if(!(user.getUserPhoneNum().isEmpty())&&!(ValidationUtils.isValidPhoneNumber(user.getUserPhoneNum())))
            return Result.error("Invalid phone number format");
        adminService.updateUser(user);
        return Result.success();
    }
    @GetMapping("admin/orders")
    public Result getOrders(@RequestParam(name="page",defaultValue = "1")Integer page,
                            @RequestParam(name="pageSize",defaultValue = "10")Integer pageSize,
                            @RequestParam(name="buyerName",required = false)String buyerName,
                            @RequestParam(name="sellerName",required = false)String sellerName,
                            @RequestParam(name="begin",required = false) LocalDate begin,
                            @RequestParam(name="buyerName",required = false)LocalDate end)
    {
        log.info("管理员查看历史订单，卖家{}，买家{}，开始时间{}，结束时间{}",sellerName,buyerName,begin,end);
        List<ReturnOrder> orderList=adminService.getOrder(page,pageSize,buyerName,sellerName,begin,end);
        return Result.success(orderList);
    }

}
