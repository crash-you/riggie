package com.liujava.controller;


import com.liujava.Enity.User;
import com.liujava.common.R;
import com.liujava.services.UserService;
import com.liujava.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证码请求
     * @param user
     * @param session
     * @return
     */
//    @PostMapping("/sendMsg")
//    public R<String> sendMsg(@RequestBody User user, HttpSession session){
//        //获取手机号
//        String phone = user.getPhone();
//
//        if(phone != null){
//            //生成随机四位验证码
//            String code = ValidateCodeUtils.generateValidateCode(4).toString();
//
//            //调用阿里云提供的短信服务API完成发送短信
//
//            //将需要生成的验证码保存到session
//        }
//
//
//
//        return null;
//    }


}
