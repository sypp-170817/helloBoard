package com.example.helloboard.aop;

import com.example.helloboard.param.request.UserReq;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class SecureAop {

    @Around("execution(* com.example.helloboard.controller.*.*_secure(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        UserReq userInfo = (UserReq) session.getAttribute("userInfo");
        if(userInfo == null) return "redirect:/";
        Object retVal = pjp.proceed();
        return retVal;
    }

}
