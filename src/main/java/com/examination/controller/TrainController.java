package com.examination.controller;

import com.examination.entity.Train;
import com.examination.entity.TrainType;
import com.examination.service.TrainService;
import com.examination.service.TrainTypeService;
import com.examination.util.JsonResult;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(description = "我的课程")
@RestController
@RequestMapping("train")
@CrossOrigin
public class TrainController {
    @Autowired
    private TrainTypeService trainTypeService;

    @Autowired
    private TrainService trainService;

    @ApiOperation(value = "增加我的课程" , notes = "传参:")
    @PostMapping("/InsertTrain")
    public boolean InsertTrain(@RequestBody Map map) {
        System.out.println(map);
        map.put("train_name" , map.get("commonality_name"));
        return trainService.InsertTrain(map) == 1;
    }

    @ApiOperation(value = "删除我的课程" , notes = "传参:")
    @PostMapping("/DeleteTrain")
    public boolean DeleteTrain(@RequestBody Map map) {
        return trainService.DeleteTrain(map) == 1;
    }

    @ApiOperation(value = "修改我的课程" , notes = "传参:")
    @PostMapping("/UpdateTrain")
    public boolean UpdateTrain(@RequestBody Map map) {
        return trainService.UpdateTrain(map) == 1;
    }

    @ApiOperation(value = "分页我的课程" , notes = "")
    @PostMapping("/FindTrain")
    public Page<Train> FindTrain(@RequestBody Map map) {
        Page<Train> page = new Page<Train>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(trainService.Total(map));
        page.setItems(trainService.FindTrain(map));
        return page;
    }

    @ApiOperation(value = "我的课程App" , notes = "")
    @PostMapping("/FindTrainAll")
    public JsonResult FindTrainAll(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setData(trainService.FindTrainAll(map));
        return jsonResult;
    }

    @ApiOperation(value = "根据id我的课程内容" , notes = "传参:id(内容id)")
    @PostMapping("/FindTrainByIdX")
    public JsonResult FindTrainByIdX(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
        Train train = trainService.FindTrainByIdX(map);
        if (train == null) {
            jsonResult.setCode(20006);
            return jsonResult;
        } else {
            jsonResult.setCode(200);
            jsonResult.setData(train);
            return jsonResult;
        }
    }
}
