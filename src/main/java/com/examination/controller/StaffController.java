package com.examination.controller;

import com.examination.entity.Staff;
import com.examination.service.StaffService;
import com.examination.util.JsonResult;
import com.examination.util.Page;
import com.examination.util.ProvinceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "员工接口")
@RestController
@RequestMapping("staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;//员工


    @ApiOperation(value = "增加员工信息" , notes = "")
    @PostMapping("/InsertStaff")
    public JsonResult InsertStaff(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
        Staff staff = staffService.FindStaffByStaffPhone(map);
        if (staff == null) {
            int i = staffService.InsertStaff(map);
            if (i == 1) {
                jsonResult.setCode(200);
                jsonResult.setMessage("增加成功!");

            } else {
                jsonResult.setCode(20006);
                jsonResult.setMessage("增加失败!");

            }
        } else {
            jsonResult.setCode(20006);
            jsonResult.setMessage("员工已存在,增加失败!");

        }

        return jsonResult;
    }

    @ApiOperation(value = "删除员工信息" , notes = "{\"id\":2}")
    @PostMapping("/DeleteStaff")
    public boolean DeleteStaff(@RequestBody Map map) {
        return staffService.DeleteStaff(map) == 1;
    }

    @ApiOperation(value = "修改员工信息" , notes = "")
    @PostMapping("/UpdateStaff")
    public boolean UpdateStaff(@RequestBody Map map) {
        return staffService.UpdateStaff(map) == 1;
    }

    @ApiOperation(value = "分页模糊查询员工信息" , notes = "{\"pageNo\":1,\"pageSize\":10}")
    @PostMapping("/FindStaff")
    public Page<Staff> FindStaff(@RequestBody Map map) {
        Page<Staff> page = new Page<Staff>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(staffService.Total(map));
        page.setItems(staffService.FindStaff(map));
        return page;
    }


}
