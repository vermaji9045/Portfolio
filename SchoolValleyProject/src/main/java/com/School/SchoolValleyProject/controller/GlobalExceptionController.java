package com.School.SchoolValleyProject.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView errorPage(Exception exception)
    {
        ModelAndView error=new ModelAndView();
        error.setViewName("error");
        error.addObject("errormsg",exception.getMessage());
        return error;
    }
}
