package com.service.Impl;

import com.dao.DetailsDao;
import com.entity.Details;
import com.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private DetailsDao detailsDao;
    @Override
    public Iterable<Details> findAll() {
        return detailsDao.findAll();
    }

    @Override
    public Boolean save(Details details) {
        Details res = detailsDao.save(details);
        if(res!=null){
            return true;
        }
        return false;
    }

    @Override
    public Details findById(Integer id) {
        return detailsDao.getById(id);
    }

    @Override
    public ArrayList<Details> findByCategoryId(Integer categoryId) {
        return detailsDao.findByCategoryId(categoryId);
    }

    @Override
    public void delete(Integer id) {
        detailsDao.deleteById(id);
    }


}
