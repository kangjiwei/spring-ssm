package cn.edu.cqie.spmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UrlIndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }



}
