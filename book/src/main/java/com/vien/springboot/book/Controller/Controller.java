package com.vien.springboot.book.Controller;

import com.vien.springboot.book.Entity.BookEntity;
import com.vien.springboot.book.Entity.SqlBook;
import com.vien.springboot.book.Service.BookService;
import com.vien.springboot.book.Service.SqlBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private BookService bookService;
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("books",bookService.findAll());

        System.out.println("betran");
        return "index";
    }


    //@GetMapping("/{id}")
    //public String bookshow(@PathVariable("id") int ID,
      //                     Model model){
        //SqlBook sqlBook=sqlBookService.getbook(ID);
        //model.addAttribute("books",sqlBook);
        //System.out.println(sqlBook);
       // return "book/view-book";
   // }
}
