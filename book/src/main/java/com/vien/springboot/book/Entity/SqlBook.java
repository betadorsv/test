package com.vien.springboot.book.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Book")
public class SqlBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "book_cover")
    private String book_cover;
    @Column(name="book_content")
    private String book_content;
    @Column(name = "describe")
    private String describe;

    private String author;



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public String getBook_cover() {
        return book_cover;
    }
    public void setBook_content(String book_content){
        this.book_content=book_content;
    }
    public String getBook_content(){
        return book_content;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


}
