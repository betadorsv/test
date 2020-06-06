package com.vien.springboot.book.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "Types")
public class TypesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private int idType;
    @Column(name = "type")
    private String name_type;
    @Column(name = "describe")
    private String describe;

    @OneToMany(mappedBy = "m_type")
    public List<BookEntity> listBooks;




    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public List<BookEntity> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<BookEntity> listBooks) {
        this.listBooks = listBooks;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


}
