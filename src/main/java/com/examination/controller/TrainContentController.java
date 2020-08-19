package com.examination.controller;

import com.examination.entity.TrainContent;
import com.examination.service.TrainContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "展馆体验接口")
@RestController
@RequestMapping("traincontent")
@CrossOrigin
public class TrainContentController {
    @Autowired
    private TrainContentService trainContentService;

    @ApiOperation(value = "根据id查询培训内容" , notes = "")
    @PostMapping("/FindTrainContent")
    public TrainContent FindTrainContent(@RequestBody Map map) {
        return trainContentService.FindTrainContent(map);
    }

    @ApiOperation(value = "查询全部展馆体验" , notes = "")
    @PostMapping("/FindTrainContentAll")
    public List<TrainContent> FindTrainContentAll(@RequestBody Map map) {
        return trainContentService.FindTrainContentAll(map);
    }

    @ApiOperation(value = "增加我的展馆培训信息" , notes = "")
    @PostMapping("/InsertTrainContent")
    public boolean InsertTrainContent(@RequestBody Map map){
        return trainContentService.InsertTrainContent(map)==1;
    }

    @ApiOperation(value = "删除我的展馆培训信息" , notes = "")
    @PostMapping("/DeleteTrainContent")
    public boolean DeleteTrainContent(@RequestBody Map map){
        return trainContentService.DeleteTrainContent(map)==1;
    }

    @ApiOperation(value = "修改我的展馆培训信息" , notes = "")
    @PostMapping("/UpdateTrainContent")
    public boolean UpdateTrainContent(@RequestBody Map map){
        return trainContentService.UpdateTrainContent(map)==1;
    }
}
