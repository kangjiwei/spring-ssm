package com.study.spmvc.controller;

import com.study.spmvc.bean.User;
import com.study.spmvc.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/User")
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        logger.info("username:{"+user.getName() +"};  password:{"+ user.getPassword() +"}");
        User getUser = userService.queryUserByNameAndPassword(user);
        if (!StringUtils.isEmpty(getUser)) {
            if (getUser.getName().equals(user.getName()) && getUser.getPassword().equals(user.getPassword())) {
                logger.info("用户("+ user.getName() +")登录成功！");
                return "1";
            }
        } else {
            logger.info("用户("+ user.getName() +")不存在！");
            return "0";
        }
        return "0";
    }


    /**
     * 没有采用ModelAndView.
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user) {
        logger.info("注册用户信息:{"+ user.getName() +"}");
        User getUser = userService.queryUserByNameAndPassword(user);
        if (user.getName() != "") {
            logger.info("用户{"+ user.getName()+"}注册成功！");
            return "1";
        } else if (!StringUtils.isEmpty(getUser)) {
            logger.info("用户{"+user.getName()+"}已经存在！");
            return "2";
        } else {
            UUID uuid = UUID.randomUUID();
            user.setId(uuid.toString());
            user.setAge("10");
            int resultInt = userService.addUser(user);
            if(resultInt > 0){
                logger.info("用户新增成功！");
            }else{
                logger.info("用户新增失败！");
            }
            return "0";
        }
    }


}
