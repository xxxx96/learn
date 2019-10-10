package com.dao;


import com.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends CrudRepository<Admin,Integer> {
    Admin findByUsernameAndPassword(String username,String password);
    Admin findById(int id);
}
