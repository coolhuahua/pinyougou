package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service//使用alibaba提供的service注解，声明将实现类放入到容器中，同时到注册中心找服务
public class BrandServiceImpl implements BrandService{
    @Autowired
    private TbBrandMapper brandMapper;

    public List<TbBrand> findAll() {
        List<TbBrand> brandList = brandMapper.findAll();
        return brandList;
    }

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.findAll();
        return new PageResult(page.getTotal(), page.getResult());
    }

}
