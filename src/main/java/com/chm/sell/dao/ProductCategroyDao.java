package com.chm.sell.dao;

import com.chm.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 注意：
 * 1.这里这里是interface，不是class
 *
 * 2.JpaRepository里面的泛型，第一个是实体类，第二个是主键的类型
 *
 * 3.由于JpaRepository 里面已经有一些接口了，如deleteAll，findOne等， 我们直接调用即可
 *
 * 4.继承了JpaRepository之后就能直接自动注入
 *
 * */
public interface ProductCategroyDao extends JpaRepository<ProductCategory, Integer> {

    @Query("from ProductCategory where categoryId =:id ")//JPQL是完全面向对象的，具备继承、多态和关联等特性，和hibernate的HQL类似。
    public ProductCategory getProductCategory(@Param("id") Integer id); //spring boot会自动实现

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
