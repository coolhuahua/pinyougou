package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

public interface TbBrandMapper {
    List<TbBrand> findAll();

    void insert(TbBrand brand);

    TbBrand selectByPrimaryKey(Long id);

    void update(TbBrand brand);

    void deleteBrand(Long id);
}
