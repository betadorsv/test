package com.vien.springboot.book.Service;

import com.vien.springboot.book.Dao.UserDao;
import com.vien.springboot.book.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
@Autowired
    UserDao userDao;
@Transactional
    public List<UserEntity> findAll(){
    List<UserEntity> userEntities=userDao.findAll();
    return userEntities;
}
@Transactional
public List<UserEntity> listUser(){
    List<UserEntity> userEntitie=userDao.listUser();
    return userEntitie;
}
    @Transactional
    public void saveUser(UserEntity userEntity){
        userDao.addUser(userEntity);
    }
    @Transactional
    public UserEntity findUser(String user){
        return   userDao.findUser(user);
    }
}
