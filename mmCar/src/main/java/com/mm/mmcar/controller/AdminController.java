package com.mm.mmcar.controller;

import com.mm.mmcar.entity.Admin;
import com.mm.mmcar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 茂茂
 * @create 2022-05-16 19:49
 */
@Controller
@RequestMapping(value = "/home")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login")
    public String login(String name, String pwd, HttpServletRequest request, HttpSession session) {
        //调用业务逻辑层login方法获取用户信息
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            //登录成功后获取登录用户名,添加欢迎信息,跳转main界面
            request.setAttribute("name", admin.getaName());
            session.setAttribute("userInfo", admin.getaName());
            return "admin/main";
        }
        //登陆失败后添加错误信息,重回login界面.
        request.setAttribute("errmsg", "<h3 style='color:mediumseagreen'>用户名或密码错误</h3>");
        return "index";
    }

    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request) {
        //登陆失败后添加错误信息,重回login界面.
        request.setAttribute("errmsg", "<h3 style='color:mediumseagreen'>请联系系统管理员分配账号</h3>");
        return "index";
    }
}
