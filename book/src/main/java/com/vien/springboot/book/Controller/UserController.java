package com.vien.springboot.book.Controller;

import com.vien.springboot.book.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;

@Controller
public class UserController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private UserService userService;




}
