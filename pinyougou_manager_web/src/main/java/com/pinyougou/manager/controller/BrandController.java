package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody//这上面两者注解可以用@RestController一个注解来替代
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageResult page = (PageResult) brandService.findPage(pageNum, pageSize);
        System.out.println("wwww:" + page);
        return page;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {//注解声明做属性的映射
        try {
            brandService.add(brand);
            return new Result(true, "新建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新建失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        TbBrand brand = brandService.findOne(id);
        return brand;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/deleBrands")
    public Result dele(Long[] ids) {
        try {
            brandService.deleteBrand(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}


