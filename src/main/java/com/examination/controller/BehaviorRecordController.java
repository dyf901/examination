package com.examination.controller;


import com.examination.entity.BehaviorRecord;
import com.examination.entity.Staff;
import com.examination.service.BehaviorRecordService;
import com.examination.service.StaffService;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Api(description = "行为记录接口")
@RestController
@RequestMapping("behaviorRecord")
@CrossOrigin
public class BehaviorRecordController {
    @Autowired
    private BehaviorRecordService behaviorRecordService;//行为记录

    @Autowired
    private StaffService staffService;//员工

    @ApiOperation(value = "增加行为记录" , notes = "测试数据:{\"staff_card\":\"340000000000000000\",\"behavior_id\":1,\"section_id\":1,\"station_idr\":1,\"remark\":\"表现优异\"}")
    @PostMapping("/InsertBehaviorRecord")
    public boolean InsertBehaviorRecord(@RequestBody Map map) {
        Staff staff = staffService.FindStaffByStaffCard(map);
        map.put("staff_id" , staff.getId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String time = format.format(now);
        map.put("uptime", time);
        return behaviorRecordService.InsertBehaviorRecord(map) == 1;
    }

    @ApiOperation(value = "删除行为记录" , notes = "测试数据:{\"id\":1}")
    @PostMapping("/DeleteBehaviorRecord")
    public boolean DeleteBehaviorRecord(@RequestBody Map map) {
        return behaviorRecordService.DeleteBehaviorRecord(map) == 1;
    }

    @ApiOperation(value = "修改行为记录" , notes = "测试数据:{\"id\":1,\"behavior_id\":1,\"remark\":\"表现优异1\"}")
    @PostMapping("/UpdateBehaviorRecord")
    public boolean UpdateBehaviorRecord(@RequestBody Map map) {
        return behaviorRecordService.UpdateBehaviorRecord(map) == 1;
    }

    @ApiOperation(value = "分页模糊查询行为记录" , notes = "测试数据:{\"pageNo\":1,\"pageSize\":10,\"section_id\":1}")
    @PostMapping("/FindBehaviorRecord")
    public Page<BehaviorRecord> FindBehaviorRecord(@RequestBody Map map) {
        Page<BehaviorRecord> page = new Page<BehaviorRecord>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(behaviorRecordService.Total(map));
        page.setItems(behaviorRecordService.FindBehaviorRecord(map));
        return page;
    }

   /* @ApiOperation(value = "分页查询个人行为记录" , notes = "")
    @PostMapping("/FindBehaviorRecordByStaff_id")
    public Page<BehaviorRecord> FindBehaviorRecordByStaff_id(@RequestBody Map map) {
        Page<BehaviorRecord> page = new Page<BehaviorRecord>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(behaviorRecordService.TotalByStaff_id(map));
        page.setItems(behaviorRecordService.FindBehaviorRecordByStaff_id(map));
        return page;
    }*/
}
