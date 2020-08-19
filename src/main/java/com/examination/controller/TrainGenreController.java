package com.examination.controller;

import com.examination.entity.TrainGenre;
import com.examination.service.TrainGenreService;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "建造类型接口")
@RestController
@RequestMapping("traingenre")
@CrossOrigin
public class TrainGenreController {
    @Autowired
    private TrainGenreService trainGenreService;

    @ApiOperation(value = "下拉框查询培训类型" , notes = "")
    @PostMapping("/SelectTrainGenre")
    public List<TrainGenre> SelectTrainGenre(@RequestBody Map map) {
        return trainGenreService.SelectTrainGenre(map);
    }
}
