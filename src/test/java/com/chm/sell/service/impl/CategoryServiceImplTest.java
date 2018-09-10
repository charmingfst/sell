package com.chm.sell.service.impl;

import com.chm.sell.dataobject.ProductCategory;
import com.chm.sell.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {

//    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Autowired
    private CategoryService categoryService;
    @Test
    public void findOne() {

        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory);
        log.info(productCategory.toString());
        log.warn("this is warn");
        log.error("this is error");
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void save() {
    }
}