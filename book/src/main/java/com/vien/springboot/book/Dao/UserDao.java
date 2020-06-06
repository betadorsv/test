package com.vien.springboot.book.Dao;


import com.vien.springboot.book.Entity.BookEntity;
import com.vien.springboot.book.Entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDao {


    @Autowired
    private EntityManager entityManager;

    public List<UserEntity> findAll(){
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("from UserEntity ");
        List<UserEntity> userEntities=query.getResultList();
        return userEntities;
    }

    public UserEntity findUser(String user){
        Session session=entityManager.unwrap(Session.class);
        Query<UserEntity> query=session.createQuery("from  UserEntity where user_name=:user");
        query.setParameter("user",user);
        UserEntity userEntity=query.getSingleResult();
        return userEntity;
    }


    public List<UserEntity> listUser(){
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("from UserEntity ");
        List<UserEntity> userEntities=query.list();
        return userEntities;
    }


    public void addUser(UserEntity userEntity){
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userEntity);
    }
}
