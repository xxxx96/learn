package com.dao;



import com.entity.Details;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DetailsDao extends CrudRepository<Details,Integer> {

    Page<Details> findAll(Pageable pageable);
    ArrayList<Details> findByCategoryId(Integer categoryId);
    Details getById(Integer id);
}
