package com.examination.controller;

import com.examination.entity.TrainCommonality;
import com.examination.service.TrainCommonalityService;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "公共课程接口")
@RestController
@RequestMapping("traincommonality")
@CrossOrigin
public class TrainCommonalityController {
    @Autowired
    private TrainCommonalityService trainCommonalityService;//公共课程

    @ApiOperation(value = "分页模糊查询公共课程" , notes = "")
    @PostMapping("/FindTrainCommonality")
    public Page<TrainCommonality> FindTrainCommonality(@RequestBody Map map) {
        Page<TrainCommonality> page = new Page<TrainCommonality>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(trainCommonalityService.Total(map));
        page.setItems(trainCommonalityService.FindTrainCommonality(map));
        return page;
    }
}
