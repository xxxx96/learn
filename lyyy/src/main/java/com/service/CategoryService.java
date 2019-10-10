package com.service;

import com.entity.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    Iterable<Category> selectAll();
}
