package com.vien.springboot.book.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_author")
    private int idAuthor;
    @Column(name = "name_author")
    private String author;
    @Column(name = "birth_day")
    private Timestamp birthDay;
    @OneToMany(mappedBy = "m_author")
    public List<BookEntity> listBooks;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookEntity> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<BookEntity> listBooks) {
        this.listBooks = listBooks;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }


    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }


}
