package com.vien.springboot.book.Dao;


import com.vien.springboot.book.Entity.BookEntity;
import com.vien.springboot.book.Entity.SqlBook;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookDao {
    @Autowired
    private EntityManager entityManager;

    public List<BookEntity> findAll(){
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("from BookEntity");

        List<BookEntity> books=query.getResultList();
        return books;
    }



    public void addbook(BookEntity bookEntity){
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(bookEntity);
    }

    public BookEntity findBook(int id){
        Session session=entityManager.unwrap(Session.class);
        Query<BookEntity> query=session.createQuery("from  BookEntity where idBook=:id");
        query.setParameter("id",id);
        BookEntity bookEntity=query.getSingleResult();
        return bookEntity;
    }

    public void deleteBook(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<SqlBook> query=session.createQuery("delete from BookEntity where idBook=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
