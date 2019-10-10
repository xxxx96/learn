package com.service.Impl;

import com.dao.AdminDao;
import com.entity.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Boolean authentication(Admin admin) {
        if(adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword())!=null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addAdmin(Admin admin) {
        return null;
    }
}
