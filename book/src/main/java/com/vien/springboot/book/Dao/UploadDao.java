package com.vien.springboot.book.Dao;

import com.vien.springboot.book.Entity.SqlBook;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface   UploadDao extends CrudRepository<SqlBook,Integer> {


}
