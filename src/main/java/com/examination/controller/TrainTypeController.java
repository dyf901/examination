package com.examination.controller;

import com.examination.entity.TrainType;
import com.examination.service.TrainTypeService;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "培训类型接口")
@RestController
@RequestMapping("traintype")
@CrossOrigin
public class TrainTypeController {
    @Autowired
    private TrainTypeService trainTypeService;

    @ApiOperation(value = "下拉框查询培训类型" , notes = "")
    @PostMapping("/SelectTrainType")
    public List<TrainType> SelectTrainType() {
        return trainTypeService.SelectTrainType();
    }


}
