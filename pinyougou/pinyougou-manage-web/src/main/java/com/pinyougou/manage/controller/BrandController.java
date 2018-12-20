package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return (List<TbBrand>) brandService.findPage(page,rows).getRows();
    }

    @GetMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "page", defaultValue = "1")Integer page, @RequestParam(value = "rows", defaultValue = "10")Integer rows) {
        return brandService.findPage(page, rows);
    }

    @PostMapping("/add.do")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return Result.ok("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.fail("新增失败");
    }

    @GetMapping("/findOne.do")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }

    @PostMapping("/update.do")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return Result.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.fail("修改失败");
    }

    @GetMapping("/delete.do")
    public Result delete(Long[] ids){
        try {
            brandService.deleteByIds(ids);
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail("删除失败");
    }

    @PostMapping("/search.do")
    public PageResult search(@RequestBody TbBrand brand,
                             @RequestParam Integer page,
                             @RequestParam Integer rows){


        /*long total = brandService.search(brand, page, rows).getTotal();
        System.out.println(total);
        if (total < (page - 1)* rows){
            return brandService.search(brand,1,rows);
        }*/
        return brandService.search(brand,page,rows);

    }

    @GetMapping("/selectOptionList")
    public List<Map<String,Object>> selectOptionList(){
        return brandService.selectOptionList();
    }


}
