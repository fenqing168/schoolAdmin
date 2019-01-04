package com.fenqing168.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@Controller
public class PageController {

    @RequestMapping("/")
    private String index(){
        return "index";
    }

    @RequestMapping("/{pageName}")
    private String toPage(@PathVariable String pageName){
        return pageName;
    }

    @RequestMapping("/pages/{pageName}")
    private String toPages(@PathVariable String pageName){
        return "/pages/" + pageName;
    }

}
