package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    public List<TbBrand> findAll();

    PageResult findPage(Integer pageNum, Integer pageSize);
}
