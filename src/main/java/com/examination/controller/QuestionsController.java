package com.examination.controller;

import com.examination.entity.Questions;
import com.examination.entity.Staff;
import com.examination.entity.Worktype;
import com.examination.service.QuestionsService;
import com.examination.util.JsonResult;
import com.examination.util.MyException;
import com.examination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(description = "题目接口")
@RestController
@RequestMapping("questions")
@CrossOrigin
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @ApiOperation(value = "增加题目" , notes = "传参:`knowledge_id`(下拉框返回), `specialty_id`(下拉框返回), `questions_type`(题目类型), `questions_content`(题目内容), `select_A`(选择题选项), `select_B`, `select_C`, `select_D`, `select_answer`(选择题答案), `judge_answer`(判断题答案), `gap_answer1`(填空题答案), `short_answer`(简答题答案)")
    @PostMapping("/InsertQuestions")
    public boolean InsertQuestions(@RequestBody Map map) {
        System.out.println("map:" + map);
//        String gap_answer = (String) map.get("gap_answer1");
//        String short_answer = (String) map.get("short_answer1");
//        map.put("gap_answer",gap_answer);
//        map.put("short_answer",short_answer);
        String str = (String) map.get("gap_answer1");
        String[] arr = str.split(","); // 用,分割
        System.out.println("arr" + Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
        map.put("gap_answer" , Arrays.toString(arr));

        String strs = (String) map.get("short_answer1");
        String[] arrs = strs.split(","); // 用,分割
        System.out.println("arrs" + Arrays.toString(arrs)); // [0, 1, 2, 3, 4, 5]
        map.put("short_answer" , Arrays.toString(arrs));
        return questionsService.InsertQuestions(map) == 1;
    }

    @ApiOperation(value = "删除题目" , notes = "传参:id(题目id)")
    @PostMapping("/DeleteQuestions")
    public boolean DeleteQuestions(@RequestBody Map map) {
        return questionsService.DeleteQuestions(map) == 1;
    }

    @ApiOperation(value = "修改题目" , notes = "测试数据:")
    @PostMapping("/UpdateQuestions")
    public boolean UpdateQuestions(@RequestBody Map map) {
        return questionsService.UpdateQuestions(map) == 1;
    }

    @ApiOperation(value = "分页模糊查询题目" , notes = "测试数据:{\"pageNo\":1,\"pageSize\":10,\"section_id\":2}")
    @PostMapping("/FindQuestions")
    public Page<Questions> FindQuestions(@RequestBody Map map) {
        Page<Questions> page = new Page<Questions>();
        page.setPageNo((Integer) map.get("pageNo"));
        page.setPageSize((Integer) map.get("pageSize"));
        page.setTotal(questionsService.Total(map));
        page.setItems(questionsService.FindQuestions(map));
        return page;
    }

    @ApiOperation(value = "根据id查询题目" , notes = "")
    @PostMapping("/FindQuestionsById")
    public JsonResult FindQuestionsById(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(questionsService.FindQuestionsById(map));
        return jsonResult;
    }

    /*@ApiOperation(value = "批量导入试题",notes = "")
    @PostMapping("/ImportQuestions")
    public boolean addUser(@RequestParam("file") MultipartFile file) throws Exception {
        boolean notNull = false;
        String fileName = file.getOriginalFilename();
        List<Staff> staffList = new ArrayList<Staff>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }

        Staff staff;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            String card1 = row.getCell(4).getStringCellValue();//身份证号
            if (card1.equals("")) {
                continue;
            }
            staff = new Staff();

            String name = row.getCell(0).getStringCellValue();//姓名
            String age = row.getCell(1).getStringCellValue();//年龄
            String sex = row.getCell(2).getStringCellValue();//性别
            String nation = row.getCell(3).getStringCellValue();//民族
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//设置身份证号格式
            //String card1 = row.getCell(3).getStringCellValue();//身份证号
            System.out.println("card1:" + card1);
            System.out.println(card1.length());
            String card = null;
            if (card1.length() >= 18) {
                card = card1.substring(0, 18);
            }
            System.out.println("card:" + card);
            String address = row.getCell(5).getStringCellValue();//地址
            row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//设置手机号格式
            String phone = row.getCell(6).getStringCellValue();//手机号
            String worktype_name = row.getCell(7).getStringCellValue();//工种

            //根据表格里面的内容判断worktype_id多少

            String img = "default.jpg";

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String time = format.format(now);

            //添加到实体类
            staff.setStaff_name(name);
            staff.setStaff_age(age);
            staff.setStaff_img(img);
            staff.setStaff_sex(sex);
            staff.setStaff_nation(nation);
            staff.setStaff_card(card);
            staff.setStaff_address(address);
            staff.setStaff_phone(phone);
            staff.setEntry_time(time);
            //添加到数组里
            staffList.add(staff);
        }
        for (Staff staff1 : staffList) {
            String staff_phone = staff1.getStaff_phone();
            System.out.println("staff_phone:" + staff_phone);
            int cnt = staffService.CountStaff(staff_phone);
            if (cnt == 0) {
                staffService.InsertStaffS(staff1);
                System.out.println(" 插入 " + staff1.toString());
            } else {
                staffService.UpdateStaffS(staff1);
                System.out.println(" 更新 " + staff1.toString());
            }
        }
        return notNull;
    }*/
}
