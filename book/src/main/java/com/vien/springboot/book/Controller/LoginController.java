package com.vien.springboot.book.Controller;

import com.vien.springboot.book.Entity.UserEntity;
import com.vien.springboot.book.Service.LoginService;
import com.vien.springboot.book.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @GetMapping("login")
    public String login(Model model) {

        return "login/login";
    }

    @RequestMapping("saveUser")
    public String saveUser(Model model,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password
    ) {
        boolean check = false;
        for (UserEntity user : userService.findAll()) {
            if (user.getUser_name().equals(username)) {
                check = true;
            }
        }
             if(check==false) {

                 UserEntity userEntity = new UserEntity();
                 userEntity.setUser_name(username.trim());
                 userEntity.setPassword(password.trim());
                 userEntity.setRoles("user");
                 System.out.println(userEntity);
                 userService.saveUser(userEntity);
             }
             else
             {
                 System.out.println("trung user");
                 model.addAttribute("message", "trung user name");
            }



    return "redirect:/list-book";
    }


    @RequestMapping("login")
    public String login(Model model, @ModelAttribute("user") UserEntity userEntity,
                           @RequestParam("user_login") String username,
                           @RequestParam("pass_login") String password
    ) throws ServletException, IOException {
        boolean check = false;
        UserEntity users = null;
        String role="";
        if (username.isEmpty() || password.isEmpty()) {

            System.out.println("vui long nhap username va mat khau");
            model.addAttribute("message", "vui long nhap username va mat khau");
        }
        else {
            for (UserEntity user : userService.findAll()) {
                if (user.getUser_name().equals(username) && user.getPassword().equals(password)) {

                    check = true;
                    users = userService.findUser(username);
                    role=user.getRoles();
                }
            }
            if (check == true) {
                LoginService.user = users;
                System.out.println("dang nhap thanh cong");
            } else {
                System.out.println("sai mat khau hoac ten dang nhap");
                model.addAttribute("message", "sai mat khau hoac ten dang nhap");
            }
        }
            return "redirect:/list-book";
        }



}
