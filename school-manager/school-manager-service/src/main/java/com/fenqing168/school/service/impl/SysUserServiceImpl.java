package com.fenqing168.school.service.impl;

import com.fenqing168.school.dao.SysUserDao;
import com.fenqing168.school.pojo.SysUserEntity;
import com.fenqing168.school.service.SysUserService;
import com.fenqing168.school.utils.CryptoUtil;
import com.fenqing168.school.utils.PasswordEncoder;
import com.fenqing168.school.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户的服务实现类
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public R login(String username, String password, String code, HttpSession httpSession) {

        if(username == null || username.equals("")){
            R.error("用户名不能为空");
        }

        if(password == null || password.equals("")){
            R.error("密码不能为空");
        }

        //获取验证码对象
        String loginCode = (String)httpSession.getAttribute("loginCode");

        if(!code.equalsIgnoreCase(loginCode)){
            return R.error("验证码不正确");
        }

        //查询username的对象
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        SysUserEntity sysUser = sysUserDao.queryObjectByMap(map);

        if(sysUser == null){
            return R.error("用户不存在！");
        }

        if(!sysUser.getStatus().equals(1)){
            return R.error("用户被禁用！");
        }

        //将密码加密
        String salt = sysUser.getSalt();

        String pass = sysUser.getPassword();

        PasswordEncoder passwordEncoder = new PasswordEncoder(salt, "MD5");

        password = passwordEncoder.encode(password);

        if(!password.equals(pass)){
            return R.error("用户名或密码错误！");
        }

        String token = CryptoUtil.encode64(CryptoUtil.DEFAULT_SECRET_KEY, sysUser.getId().toString());

        return R.ok("登录成功！", token);
    }
}
