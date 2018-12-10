package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BrandController class
 *
 * @Author: lonelywind
 * @Date: 2018/12/10 21:15
 */
@RequestMapping("/brand")
@RestController
public class BrandController {


    @Reference
    private BrandService brandService;

    @GetMapping("/testPage")
    public List<TbBrand> testPage(Integer page, Integer rows){
        return brandService.testPage(page,rows);
    }

    @GetMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.queryAll();
    }
}
