package com.vien.springboot.book.Service;

import com.vien.springboot.book.Dao.TypeDao;
import com.vien.springboot.book.Entity.AuthorEntity;
import com.vien.springboot.book.Entity.TypesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypesService {

    @Autowired
    TypeDao typeDao;
    @Transactional
    public List<TypesEntity> findall(){
        List<TypesEntity> typesEntities=typeDao.findall();
        return typesEntities;
    }
    @Transactional
    public TypesEntity getType(int id){
        return typeDao.findType(id);
    }
}
