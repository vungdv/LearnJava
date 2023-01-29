package com.vungdo.peopledbweb.web.controller;

import com.vungdo.peopledbweb.exception.StorageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorController {
    @ExceptionHandler(StorageException.class)
    public String handleStorageException(StorageException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
