package com.examination.controller;

import com.examination.entity.Ttype;
import com.examination.service.TtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "我的培训类型接口")
@RestController
@RequestMapping("Ttype")
@CrossOrigin
public class TtypeController {
    @Autowired
    private TtypeService ttypeService;

    @ApiOperation(value = "增加我的培训类型" , notes = "")
    @PostMapping("/InsertTtype")
    public boolean InsertTtype(@RequestBody Map map) {
        return ttypeService.InsertTtype(map)==1;
    }

    @ApiOperation(value = "删除我的配信类型" , notes = "")
    @PostMapping("/DeleteTtype")
    public boolean DeleteTtype(@RequestBody Map map) {
        return ttypeService.DeleteTtype(map)==1;
    }

    @ApiOperation(value = "修改我的培训类型" , notes = "")
    @PostMapping("/UpdateTtype")
    public boolean UpdateTtype(@RequestBody Map map) {
        return ttypeService.UpdateTtype(map)==1;
    }

    @ApiOperation(value = "查询我的培训类型" , notes = "")
    @PostMapping("/FindTtype")
    public List<Ttype> FindTtype(@RequestBody Map map) {
        return ttypeService.FindTtype(map);
    }
}
