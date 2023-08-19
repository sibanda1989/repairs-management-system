package com.stingtech.rms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

/*
This class is used to handle all exceptions in the project,
and pass on intuitive error messages to the user
 */

@ControllerAdvice
public class GlobalExceptionHandler {
//    public String handleIllegalStateException(IllegalStateException ex, Model model){
//        String errorMessage = ex.getMessage();  //Retrieve the exception message dynamically
//        model.addAttribute("errorMessage", errorMessage);
//        return "error";
//    }
}
