package com.controller;

import com.dao.AdminDao;
import com.dao.CategoryDao;
import com.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@RestController
public class TestController {
@Resource
private AdminDao adminDao;
  @Resource
  private CategoryDao categoryDao;
  @Autowired
  private ServletContext servletContext;
@RequestMapping("test")
public String test(){
  return   categoryDao.findAll().toString()+servletContext.getAttribute("token").toString();
}
}
