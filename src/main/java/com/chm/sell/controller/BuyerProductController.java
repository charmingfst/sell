package com.chm.sell.controller;

import com.chm.sell.dataobject.ProductCategory;
import com.chm.sell.dataobject.ProductInfo;
import com.chm.sell.service.CategoryService;
import com.chm.sell.service.ProductService;
import com.chm.sell.vo.ProductInfoVO;
import com.chm.sell.vo.ProductVO;
import com.chm.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@Controller
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/test")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("redirect:/pay.html");
        modelAndView.getModel().put("name", "[Angel -- 守护天使]");
        System.out.println("pay");
        return modelAndView;
    }

    @GetMapping("/list")
    private ResultVO list() {
        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2. 查询类目（数据库查询不要放入循环）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(item -> item.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList)
        {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList)
            {
                if (productInfo.getCategoryType().equals(productVO.getCategoryType()))
                {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();

//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(productVOList);
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }

    @RequestMapping(value = "/error")
    public String errorHtml(HttpServletRequest request) {
        return "404";
    }

}
