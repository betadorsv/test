package com.vien.springboot.book.Dao;

import com.vien.springboot.book.Entity.AuthorEntity;
import com.vien.springboot.book.Entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorDao {


    @Autowired
    private EntityManager entityManager;
    public List<AuthorEntity> findAll(){
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("from AuthorEntity ");

        List<AuthorEntity> authors=query.getResultList();
        return authors;
    }

    public AuthorEntity findAuthor(int id){
        Session session=entityManager.unwrap(Session.class);
        Query<AuthorEntity> query=session.createQuery("from  AuthorEntity where idAuthor=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
