package com.service.Impl;

import com.dao.CategoryDao;
import com.entity.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
    private CategoryDao categoryDao;

    @Override
    public Iterable<Category> selectAll() {
        return categoryDao.findAll();
    }


}
