package com.example.helloboard.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ModelAndView handleConflict(RuntimeException ex, WebRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("root");
        mv.addObject("message", ex.getMessage());
        return mv;
    }
}
