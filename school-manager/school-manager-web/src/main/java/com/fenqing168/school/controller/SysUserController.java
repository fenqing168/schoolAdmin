package com.fenqing168.school.controller;

import com.fenqing168.school.service.SysUserService;
import com.fenqing168.school.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 系统用户控制器
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param httpSession 会话
     * @return
     */
    @PostMapping("login")
    public R login(String username, String password, String code, HttpSession httpSession){
        return sysUserService.login(username, password, code, httpSession);
    }

}
