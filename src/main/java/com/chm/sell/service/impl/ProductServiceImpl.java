package com.chm.sell.service.impl;

import com.chm.sell.dao.ProductCategroyDao;
import com.chm.sell.dao.ProductInfoDao;
import com.chm.sell.dataobject.ProductInfo;
import com.chm.sell.enums.ProductStatusEnum;
import com.chm.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao repository;

    @Override
    public ProductInfo findOne(String productId) {

        return repository.getOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
