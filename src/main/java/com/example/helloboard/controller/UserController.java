package com.example.helloboard.controller;

import com.example.helloboard.param.request.UserReq;
import com.example.helloboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserReq userReq, HttpSession session){
        userService.join(userReq);
        session.setAttribute("userInfo", userReq);
        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("login")
    public String login(@ModelAttribute UserReq userReq, HttpSession session) throws IllegalAccessException {
        userService.login(userReq);
        session.setAttribute("userInfo", userReq);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout_secure(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
