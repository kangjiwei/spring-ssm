package cn.edu.cqie.spmvc.controller;

import cn.edu.cqie.spmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/User")
public class IndexController {

    public static final Map<String, User> userInfo = new HashMap<>();

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        System.out.println("username===" + user.getName());
        System.out.println("password===" + user.getPassword());
        User getUser = this.getUserInfo(user);
        if (!StringUtils.isEmpty(getUser)) {
            if(getUser.getName().equals(user.getName()) && getUser.getPassword().equals(user.getPassword())){
                System.out.println("登陆成功！");
                return "1";
            }
        } else {
            System.out.println("没有该用户信息!");
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
        System.out.println("username===" + user.getName());
        System.out.println("password===" + user.getPassword());
        User getUser = this.getUserInfo(user);
        if (user.getName() != "") {
            userInfo.put(user.getName(), user);
            System.out.println("注册成功!");
            return "1";
        } else if (!StringUtils.isEmpty(getUser)) {
            System.out.println("该用户已经存在了！");
            return "2";
        }else{
            return "0";
        }
    }

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    public User getUserInfo(User user) {
        User getUser = userInfo.get(user.getName());
        return getUser;
    }

}
