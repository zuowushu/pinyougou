package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService extends BaseService<TbBrand> {
    /**
     *
     * @return
     */
    List<TbBrand> queryAll();

    /**
     *
     * @param page
     * @param rows
     * @return
     */
    List<TbBrand> testPage(Integer page, Integer rows);

    /**
     *
     * @param brand
     * @param page
     * @param rows
     * @return PageResult
     */
    PageResult search(TbBrand brand, Integer page, Integer rows);

    List<Map<String, Object>> selectOptionList();
}
