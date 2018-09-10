package com.chm.sell.service.impl;

import com.chm.sell.dao.ProductCategroyDao;
import com.chm.sell.dataobject.ProductCategory;
import com.chm.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategroyDao repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> result = repository.findById(categoryId);
        if (result.isPresent()) {
            return result.get();
        }else {
            return null;
        }
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
