package com.stingtech.rms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
This class is used to handle all exceptions in the project,
and pass on intuitive error messages to the user
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleGenericError(Exception ex, Model model){
        String errorMessage = ex.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalStateException(IllegalStateException ex, Model model){
        String errorMessage = ex.getMessage();  //Retrieve the exception message dynamically
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
