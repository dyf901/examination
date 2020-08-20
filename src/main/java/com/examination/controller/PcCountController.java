package com.examination.controller;


import com.examination.entity.Questions;
import com.examination.entity.Staff;
import com.examination.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(description = "PC端统计图数据接口")
@RestController
@RequestMapping("count_PC")
@CrossOrigin
public class PcCountController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainCommonalityService trainCommonalityService;

    @Autowired
    private ExamRecordService examRecordService;

    @ApiOperation(value = "试题总数" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountST")
    public int CountST(@RequestBody Map map) {
        return questionsService.CountAll(map);
    }

    @ApiOperation(value = "试卷总数" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountSJ")
    public int CountSJ(@RequestBody Map map) {
        return examinationService.CountAll(map);
    }

    @ApiOperation(value = "学员总数" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountXY")
    public int CountXY(@RequestBody Map map) {
        return staffService.CountAll(map);
    }

    @ApiOperation(value = "培训课程总数" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountPXKC")
    public int CountPXKC(@RequestBody Map map) {
        return trainService.CountAll(map);
    }

    @ApiOperation(value = "公共课程总数" , notes = "")
    @PostMapping("/CountGGKC")
    public int CountGGKC(@RequestBody Map map) {
        return trainCommonalityService.CountAll(map);
    }

    @ApiOperation(value = "考试合格率" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountKSHGL")
    public Double CountKSHGL(@RequestBody Map map) {
        double i = examRecordService.CountT(map);
        double l = examRecordService.CountAll(map);
        double s = (i / l) * 100;
        return s;
    }

    @ApiOperation(value = "专业知识分布" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountByKnowledge")
    public List<Questions> CountByKnowledge(@RequestBody Map map) {
        return questionsService.CountByKnowledge(map);
    }

    @ApiOperation(value = "专业知识分布" , notes = "测试数据:{\"section_id\":2}")
    @PostMapping("/CountBySpecialty")
    public List<Questions> CountBySpecialty(@RequestBody Map map) {
        return questionsService.CountBySpecialty(map);
    }
}
