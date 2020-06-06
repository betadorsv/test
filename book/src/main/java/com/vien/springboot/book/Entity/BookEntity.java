package com.vien.springboot.book.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;
    @Column(name = "title")
    private String title;
    @Column(name = "book_cover")
    private String bookCover;
    @Column(name = "book_content")
    private String bookContent;
    @Column(name = "describe")
    private String describe;


    @ManyToOne
    @JoinColumn(name="id_author")
    private AuthorEntity m_author;

    @ManyToOne
    @JoinColumn(name="id_type")
    private TypesEntity m_type;

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public void setM_author(AuthorEntity m_author) {
        this.m_author = m_author;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setMtype(TypesEntity m_type) {
        this.m_type = m_type;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getBookCover() {
        return bookCover;
    }

    public String getBookContent() {
        return bookContent;
    }

    public AuthorEntity getM_author() {
        return m_author;
    }

    public String getDescribe() {
        return describe;
    }

    public TypesEntity getM_type() {
        return m_type;
    }

    public void setM_type(TypesEntity m_type) {
        this.m_type = m_type;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", bookCover='" + bookCover + '\'' +
                ", bookContent='" + bookContent + '\'' +
                ", m_author=" + m_author +
                ", describe='" + describe + '\'' +
                ", m_type=" + m_type +
                '}';
    }
}
