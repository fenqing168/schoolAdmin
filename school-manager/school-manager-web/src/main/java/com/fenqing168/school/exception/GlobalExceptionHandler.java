package com.fenqing168.school.exception;

import com.fenqing168.school.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AjaxException.class)
    @ResponseBody
    public R ajaxException(HttpServletRequest req, Exception e){
        e.printStackTrace();
        return R.error("系统异常，请联系管理员！");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R Exception(HttpServletRequest req, Exception e){
        e.printStackTrace();
        return R.error("系统异常，请联系管理员！");
    }

}
