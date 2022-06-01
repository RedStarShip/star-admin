package com.star.controller;

import com.star.entity.Category;
import com.star.service.CategoryService;
import com.star.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类(Category)表控制层
 *
 * @author makejava
 * @since 2022-06-01 16:10:38
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //类别列表
    @GetMapping
    public List<Category> categoryList() {
        return categoryService.queryByFirstLevel();
    }

    //部分更新
    @PatchMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        log.info("更新类别id", id);
        log.info("更新类别信息", JSONUtils.writerJSON(category));
        category.setId(id);
        return categoryService.update((category));
    }

    //添加类别
    @PostMapping
    public Category save(@RequestBody Category category) {
        log.info("添加的类别信息", JSONUtils.writerJSON(category));
        return categoryService.insert(category);
    }

    //删除类别
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        log.info("删除类别的id",id);
        categoryService.deleteById(id);
    }
}

