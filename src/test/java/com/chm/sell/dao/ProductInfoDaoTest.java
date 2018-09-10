package com.chm.sell.dao;

import com.chm.sell.dataobject.ProductInfo;
import com.chm.sell.enums.ProductStatusEnum;
import com.chm.sell.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private  ProductInfoDao repository;

    @Test
    public void testSave()
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal((3.2)));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好喝的粥");
        productInfo.setProductIcon("http://www.xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = repository.findByProductStatus(ProductStatusEnum.valueOf("UP").getCode());
        Assert.assertNotEquals(0, result);
    }
















}