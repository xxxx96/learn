package com.service;

import com.entity.Details;

import java.util.ArrayList;
import java.util.Optional;

public interface DetailsService {
    Iterable<Details> findAll();
    Boolean save(Details details);
    Details findById(Integer id);
    ArrayList<Details> findByCategoryId(Integer categoryId);
    void delete(Integer id);
}
