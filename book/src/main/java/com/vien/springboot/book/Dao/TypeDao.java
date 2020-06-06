package com.vien.springboot.book.Dao;


import com.vien.springboot.book.Entity.TypesEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TypeDao {
    @Autowired
    EntityManager entityManager;
    public List<TypesEntity> findall(){
        Session session=entityManager.unwrap(Session.class);
        Query query=session.createQuery("from TypesEntity ");
        List<TypesEntity> typesEntities=query.getResultList();
        return typesEntities;
    }
    public TypesEntity findType(int id){
        Session session=entityManager.unwrap(Session.class);
        Query<TypesEntity> query=session.createQuery("from  TypesEntity where idType=:id");
        query.setParameter("id",id);
        TypesEntity typesEntity =query.getSingleResult();
        return typesEntity;
    }
}
