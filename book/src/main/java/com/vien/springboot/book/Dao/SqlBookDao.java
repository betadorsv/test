package com.vien.springboot.book.Dao;

import com.vien.springboot.book.Entity.SqlBook;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class SqlBookDao {
    @Autowired
    private EntityManager entityManager;
    public List<SqlBook> findAll(){
      Session session=entityManager.unwrap(Session.class);
      Query query=session.createQuery("from SqlBook");
       List<SqlBook> books=query.getResultList();
        return books;
    }



}
