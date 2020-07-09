package com.examination.controller;

import com.examination.entity.TrainContentW;
import com.examination.service.TrainContentWService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "公共展馆体验接口")
@RestController
@RequestMapping("traincontentW")
@CrossOrigin
public class TrainContentWController {
    @Autowired
    private TrainContentWService trainContentWService;

    @ApiOperation(value = "根据id查询公共展馆体验" , notes = "")
    @PostMapping("/FindTrainContent")
    public TrainContentW FindTrainContent(@RequestBody Map map) {
        return trainContentWService.FindTrainContentW(map);
    }

    @ApiOperation(value = "查询全部公共展馆体验" , notes = "")
    @PostMapping("/FindTrainContentAll")
    public List<TrainContentW> FindTrainContentAll(@RequestBody Map map) {
        return trainContentWService.FindTrainContentWAll();
    }
}
