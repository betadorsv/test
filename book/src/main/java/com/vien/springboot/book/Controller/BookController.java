package com.vien.springboot.book.Controller;

import com.vien.springboot.book.Entity.AuthorEntity;
import com.vien.springboot.book.Entity.BookEntity;

import com.vien.springboot.book.Entity.TypesEntity;
import com.vien.springboot.book.Service.AuthorService;
import com.vien.springboot.book.Service.BookService;

import com.vien.springboot.book.Service.LoginService;
import com.vien.springboot.book.Service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class BookController {

    @Autowired
    ServletContext servletContext;
   @Autowired
    BookService bookService;
   @Autowired
    AuthorService authorService;
   @Autowired
    TypesService typesService;
    @GetMapping("managerBook")
    public String ManagerBook(Model model){
        model.addAttribute("books",bookService.findAll());
        return "admin/managerBook";
    }

    @GetMapping("list-book")
    public  String getListBook(Model model)

    {
        model.addAttribute("user", LoginService.user);

        model.addAttribute("books", bookService.findAll());
        return  "book/list-book";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model) {
        BookEntity bookEntity = new BookEntity();
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("types",typesService.findall());
        model.addAttribute("books", bookEntity);

        return "upload/upload";
    }
    @RequestMapping("Update-Book")
    public  String UploadFile(Model model, @ModelAttribute BookEntity bookEntity,
                              @RequestParam("id_author") int author,
                              @RequestParam("id_type") int type,
                              @RequestParam("photo_file") MultipartFile book_cover,
                              @RequestParam("content_file") MultipartFile content_file

    ){
            try{
                if (!book_cover.isEmpty()) {
                        bookService.saveImage(book_cover);
                        String book_cover_file=book_cover.getOriginalFilename();
                        bookEntity.setBookCover(book_cover_file);
                }
                if (!content_file.isEmpty()) {

                        bookService.saveContent(content_file);
                        String contents_file=content_file.getOriginalFilename();
                        bookEntity.setBookContent(contents_file);
          }
            } catch (Exception e) {
                e.printStackTrace();
            }

        AuthorEntity authorEntity=authorService.getAuthor(author);
        bookEntity.setM_author(authorEntity);
        TypesEntity typesEntity=typesService.getType(type);
        bookEntity.setMtype(typesEntity);

        bookService.savebook(bookEntity);


        return "redirect:/managerBook";
    }


    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(Model model,
            @RequestParam("BookId") int ID){
     BookEntity bookEntity=bookService.getbook(ID);
     model.addAttribute("books",bookEntity);
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("types",typesService.findall());
     return "admin/edit-book";
   }

//update mo, ham update
     @GetMapping("DeleteBook")
   public String DeleteBook(@RequestParam("BookId") int ID,
                           Model model){
   bookService.deleteBook(ID);
      return "redirect:/managerBook";
    }


    @GetMapping("showbook")
    public String showbook(@RequestParam("BookId") int ID,
                           Model model){
        BookEntity bookEntity=bookService.getbook(ID);
        model.addAttribute("books",bookEntity);
        System.out.println(bookEntity);
        return "book/view-book";
    }
}
