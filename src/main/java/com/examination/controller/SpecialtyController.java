package com.examination.controller;

import com.examination.entity.Specialty;
import com.examination.service.SpecialtyService;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "专业分类接口")
@RestController
@RequestMapping("specialty")
@CrossOrigin
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;//专业分类

    @ApiOperation(value = "增加专业类型" , notes = "传参:")
    @PostMapping("/InsertSpecialty")
    public boolean InsertSpecialty(@RequestBody Map map) {
        return specialtyService.InsertSpecialty(map) == 1;
    }

    @ApiOperation(value = "删除专业分类" , notes = "传参:")
    @PostMapping("/DeleteSpecialty")
    public boolean DeleteSpecialty(@RequestBody Map map) {
        return specialtyService.DeleteSpecialty(map) == 1;
    }

    @ApiOperation(value = "修改专业分类" , notes = "传参:")
    @PostMapping("/UpdateSpecialty")
    public boolean UpdateSpecialty(@RequestBody Map map) {
        return specialtyService.UpdateSpecialty(map) == 1;
    }

    @ApiOperation(value = "分页查询专业分类" , notes = "传参:")
    @PostMapping("/FindSpecialty")
    public Page<Specialty> FindSpecialty(@RequestBody Map map) {
        Page<Specialty> page = new Page<Specialty>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(specialtyService.Total());
        page.setItems(specialtyService.FindSpecialty(map));
        return page;
    }

    @ApiOperation(value = "下拉框查询专业分类" , notes = "传参:section_id")
    @PostMapping("/SelectSpecialty")
    public List<Specialty> SelectSpecialty() {
        return specialtyService.SelectSpecialty();
    }
}
