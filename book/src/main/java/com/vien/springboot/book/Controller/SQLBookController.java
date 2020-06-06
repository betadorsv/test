package com.vien.springboot.book.Controller;


import com.vien.springboot.book.Entity.BookEntity;
import com.vien.springboot.book.Entity.SqlBook;
import com.vien.springboot.book.Service.BookService;
import com.vien.springboot.book.Service.SqlBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller

public class SQLBookController {
@Autowired
BookService bookService;

   // @GetMapping("showFormForUpdate")
   // public String showFormForUpdate(@RequestParam("BookId") int ID,
     //                               Model model){
      //  SqlBook sqlBook=bookService.getbook(ID);
       // model.addAttribute("books",sqlBook);
       // return "upload/upload";
  //  }


   // @GetMapping("DeleteBook")
   // public String DeleteBook(@RequestParam("BookId") int ID,
     //                        Model model){
    //sqlBookService.deleteBook(ID);
      //  return "redirect:/managerBook";
    //}
}
