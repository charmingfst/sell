package com.chm.sell.service.impl;

import com.chm.sell.dataobject.ProductInfo;
import com.chm.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productServiceImpl;


    @Test
    public void findOne() {
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productServiceImpl.findUpAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }
}