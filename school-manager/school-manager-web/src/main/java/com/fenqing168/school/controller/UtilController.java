package com.fenqing168.school.controller;

import com.fenqing168.school.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/sys/util")
public class UtilController {

    /**
     * 返回图片验证码
     * @param req 请求
     * @param resp 响应
     * @throws IOException
     */
    @GetMapping("/codeImage")
    public void codeImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ImageUtil imageUtil = new ImageUtil(300, 200, 4, null, 50, 10);
        imageUtil.init();
        String code = imageUtil.getCode();
        BufferedImage bi = imageUtil.getBi();
        req.getSession().setAttribute("loginCode", code);
        ImageIO.write(bi,"png", resp.getOutputStream());

    }

}
