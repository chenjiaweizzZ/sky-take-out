package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类接口相关")
public class CategroyController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/save")
    @ApiOperation("分类保存")
    public Result save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    @PostMapping("/startOrStop")
    @ApiOperation("起售、停售")
    public Result startOrStop(Integer status, Long id) {
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    @PostMapping("/update")
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除分类")
    public Result<String> deleteById(Long id){
        log.info("删除分类：{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }
}
