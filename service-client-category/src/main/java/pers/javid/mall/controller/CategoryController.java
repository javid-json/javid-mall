package pers.javid.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.javid.mall.dto.Message;
import pers.javid.mall.entity.Category;
import pers.javid.mall.service.CategoryService;

import java.util.List;

import static pers.javid.mall.dto.Message.failed;
import static pers.javid.mall.dto.Message.success;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Message SelectAll(){
        log.info("获取所有商品分类");
        try{
            List<Category> list = categoryService.selectAll();
            return success(list);
        }catch(Exception e){
            e.printStackTrace();
        }
        return failed("获取商品分类异常");
    }

    @GetMapping("/index/{catlimit}")
    public Message getIndexCat(@PathVariable("catlimit") int catlimit){
        log.info("获取首页商品分类");
        try{
            List<List<Category>> list = categoryService.getIndexCat(catlimit);
            return success(list);
        }catch(Exception e){
            e.printStackTrace();
        }
        return failed("获取商品分类异常");
    }
}
