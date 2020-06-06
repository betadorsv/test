package com.vien.springboot.book.Service;

import com.vien.springboot.book.Dao.BookDao;
import com.vien.springboot.book.Dao.SqlBookDao;
import com.vien.springboot.book.Entity.BookEntity;
import com.vien.springboot.book.Entity.SqlBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    @Autowired
    ServletContext servletContext;
    List<String> imageTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");
    List<String> contentTypes = Arrays.asList("application/pdf");
    @Transactional
        public List<BookEntity> findAll(){
            List<BookEntity> books=bookDao.findAll();
            return books;
    }
    @Transactional
    public void savebook(BookEntity bookEntity){
        bookDao.addbook(bookEntity);
    }
    @Transactional
    public String saveImage(MultipartFile file) throws Exception{

        if(!imageTypes.contains(file.getContentType())){
            throw new Exception("day k phai hinh");
        }

        String folder = servletContext.getRealPath("/") +"/FileUpload/image/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder +file.getOriginalFilename());
        Files.write(path,bytes);
        return path.toString();
    }
    @Transactional
    public String saveContent(MultipartFile file) throws Exception{

        if(!contentTypes.contains(file.getContentType())){
            throw new Exception("day khong phai pdf");
        }

        String folder = servletContext.getRealPath("/") +"/FileUpload/content/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder +file.getOriginalFilename());
        Files.write(path,bytes);
        return path.toString();
    }
    @Transactional
    public BookEntity getbook(int id){
        return bookDao.findBook(id);
    }
    @Transactional
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

}
