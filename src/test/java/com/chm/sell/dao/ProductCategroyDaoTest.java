package com.chm.sell.dao;

import com.chm.sell.dao.ProductCategroyDao;
import com.chm.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan("com.chm.sell.dataobject")
public class ProductCategroyDaoTest {

    @Autowired
    private ProductCategroyDao repository;

    @Test
    public void testFindOne()
    {
        ProductCategory pc1 = new ProductCategory();
        pc1.setCategoryId(1);
        Optional<ProductCategory> optional = repository.findById(1);
        optional.ifPresent(System.out::println);
        pc1 = repository.getProductCategory(1);
        System.out.println(pc1);
    }

    @Test
    @Transactional //在单元测试中，事务回滚保持数据库干净
    public void testSave()
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(8);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByCategoryTypeIn()
    {
        List<Integer> list = Arrays.asList(2,3,5);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}