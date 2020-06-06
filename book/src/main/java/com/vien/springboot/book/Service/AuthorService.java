package com.vien.springboot.book.Service;

import com.vien.springboot.book.Dao.AuthorDao;
import com.vien.springboot.book.Entity.AuthorEntity;
import com.vien.springboot.book.Entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;
    @Transactional
    public List<AuthorEntity> findAll(){

        List<AuthorEntity> authors=authorDao.findAll();
        return authors;
    }
    @Transactional
    public AuthorEntity getAuthor(int id){
        return authorDao.findAuthor(id);
    }


}
