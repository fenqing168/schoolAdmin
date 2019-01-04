package com.fenqing168.school.service;

import com.fenqing168.school.utils.R;

import javax.servlet.http.HttpSession;

/**
 * 系统用户 服务接口
 */
public interface SysUserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param httpSession 会话
     * @return
     */
    R login(String username, String password, String code, HttpSession httpSession);

}
