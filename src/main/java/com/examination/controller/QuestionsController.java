package com.examination.controller;

import com.examination.entity.*;
import com.examination.service.KnowledgeService;
import com.examination.service.QuestionsService;
import com.examination.service.SpecialtyService;
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

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private SpecialtyService specialtyService;

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
        System.out.println("map:"+map);
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

    @ApiOperation(value = "批量导入试题",notes = "")
    @PostMapping("/ImportQuestions")
    public boolean addUser(@RequestParam("file") MultipartFile file) throws Exception {
        boolean notNull = false;
        String fileName = file.getOriginalFilename();
        List<Questions> questionsList = new ArrayList<Questions>();
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

        Questions questions = null;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            String questions_type = row.getCell(2).getStringCellValue();//题目类型(选择,填空,判断,简答)
            if (questions_type.equals("")) {
                continue;
            }
            questions = new Questions();

            String knowledge1 = row.getCell(0).getStringCellValue();//知识
            List<Knowledge> knowledgeList = knowledgeService.SelectKnowledge();
            int knowledge_id = 0;
            for (int i = 0; i < knowledgeList.size(); i++) {
                Knowledge knowledge = knowledgeList.get(i);
                if (knowledge.getKnowledge_name().equals(knowledge1)) {
                    knowledge_id = knowledge.getId();
                }
            }

            String specialty1 = row.getCell(1).getStringCellValue();//专业
            List<Specialty> specialtyList = specialtyService.SelectSpecialty();
            int specialty_id = 0;
            for (int i = 0; i < specialtyList.size(); i++) {
                Specialty specialty = specialtyList.get(i);
                if (specialty.getSpecialty_name().equals(specialty1)) {
                    specialty_id = specialty.getId();
                }
            }

            String questions_content = row.getCell(3).getStringCellValue();//题目内容

            if (questions_type.equals("选择题")){
                String select_A = row.getCell(4).getStringCellValue();//选择题A选项

                String select_B = row.getCell(5).getStringCellValue();//选择题B选项

                String select_C = row.getCell(6).getStringCellValue();//选择题C选项

                String select_D = row.getCell(7).getStringCellValue();//选择题D选项

                String select_answer = row.getCell(8).getStringCellValue();//选择答案

                questions.setSelect_A(select_A);
                questions.setSelect_B(select_B);
                questions.setSelect_C(select_C);
                questions.setSelect_D(select_D);
                questions.setSelect_answer(select_answer);
            }

            if (questions_type.equals("判断题")){

                String judge_answer1 = row.getCell(4).getStringCellValue();//判断题答案(1 为true,0为false)

                Boolean judge_answer = null;
                if (judge_answer1.equals("正确")){
                    judge_answer=true;
                }else {
                    judge_answer=false;
                }

                questions.setJudge_answer(judge_answer);
            }
            //添加到实体类
            questions.setKnowledge_id(knowledge_id);
            questions.setSpecialty_id(specialty_id);
            questions.setQuestions_type(questions_type);
            questions.setQuestions_content(questions_content);


            questionsList.add(questions);
            
        }
        for (Questions questions1 : questionsList) {
            questionsService.InsertQuestionsQ(questions);
        }
        return notNull;
    }
}
