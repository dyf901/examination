package com.examination.controller;

import com.examination.entity.Staff;
import com.examination.service.StaffService;
import com.examination.util.JsonResult;
import com.examination.util.MyException;
import com.examination.util.Page;
import com.examination.util.ProvinceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /*@ApiOperation(value = "批量导入" , notes = "")
    @PostMapping("/import")
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

        Map<String, PictureData> maplist = null;
        sheet = wb.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (isExcel2003) {
            maplist = getPictures1((HSSFSheet) sheet);
        } else {
            maplist = getPictures2((XSSFSheet) sheet);
        }
        try {
            printImg(maplist);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放map
            if (maplist != null) {
                maplist = null;
            }
        }
        Staff staff;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            String card1 = row.getCell(3).getStringCellValue();//身份证号
            if (card1.equals("")) {
                continue;
            }
            staff = new Staff();

            String name = row.getCell(0).getStringCellValue();//姓名
            String sex = row.getCell(1).getStringCellValue();//性别
            String nation = row.getCell(2).getStringCellValue();//民族
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//设置身份证号格式
            //String card1 = row.getCell(3).getStringCellValue();//身份证号
            System.out.println("card1:" + card1);
            System.out.println(card1.length());
            String card = null;
            if (card1.length() >= 18) {
                card = card1.substring(0, 18);
            }
            System.out.println("card:" + card);
            String address = row.getCell(4).getStringCellValue();//地址
            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//设置手机号格式
            String phone = row.getCell(5).getStringCellValue();//手机号
            String sos_name = row.getCell(6).getStringCellValue();//紧急联系人
            String sos_ship = row.getCell(7).getStringCellValue();//紧急联系人关系
            row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//设置紧急联系人号码格式
            String sos_phone = row.getCell(8).getStringCellValue();//紧急联系人电话
            //String img_url = row.getCell(9).getStringCellValue();//照片

            row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
            //int department_id = Integer.parseInt(row.getCell(9).getStringCellValue());
            String department_name = row.getCell(9).getStringCellValue();
            List<Department> department = departmentService.select_department();
            int department_id = 0;
            for (int i = 0; i < department.size(); i++) {
                Department department1 = department.get(i);
                if (department1.getName().equals(department_name)) {
                    department_id = department1.getId();
                }
            }

            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
            //int worktype_id = Integer.parseInt(row.getCell(10).getStringCellValue());
            String worktype_name = row.getCell(10).getStringCellValue();
            List<WorkType> worktype = workTypeService.select_worktype();
            int worktype_id = 0;
            for (int j = 0; j < worktype.size(); j++) {
                WorkType worktype1 = worktype.get(j);
                if (worktype1.getName().equals(worktype_name)) {
                    worktype_id = worktype1.getId();
                }
            }


            String type = row.getCell(11).getStringCellValue();//班组

            String img = row.getCell(12).getStringCellValue();//图片
            System.out.println("img" + img);

            String img_url = null;

            if (img.equals("null")) {
                img_url = "default.jpg";

            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
                //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                img_url = r + "." + df.format(new Date()) + ".jpg";
            }


            //添加到实体类
            staff.setName(name);
            staff.setSex(sex);
            staff.setNation(nation);
            staff.setCard(card);
            staff.setAddress(address);
            staff.setPhone(phone);
            staff.setSos_name(sos_name);
            staff.setSos_ship(sos_ship);
            staff.setSos_phone(sos_phone);
            staff.setImg_url(img_url);
            staff.setDepartment_id(department_id);
            staff.setWorktype_id(worktype_id);
            staff.setType(type);


            //添加到数组里
            staffList.add(staff);
        }
        for (Staff staff1 : staffList) {
            String card = staff1.getCard();
            System.out.println(card);
            int cnt = staffService.CountByCard(card);
            if (cnt == 0) {
                staffService.InsertStaff(staff1);
                System.out.println(" 插入 " + staff1.toString());
            } else {
                staffService.UpdateStaffByCard(staff1);
                System.out.println(" 更新 " + staff1.toString());
            }
        }
        return notNull;
    }*/

    /**
     * 获取图片和位置 (xls)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures1(HSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                //String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                String key = String.valueOf(cAnchor.getRow1());
                map.put(key, pdata);
            }
        }
        return map;
    }

    /**
     * 获取图片和位置 (xlsx)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures2(XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    //String key = marker.getRow() + "-" + marker.getCol();
                    String key = String.valueOf(marker.getRow());
                    //System.out.println(key);
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }

    //图片写出
    public static void printImg(Map<String, PictureData> sheetList) throws Exception {
        Object key[] = sheetList.keySet().toArray();
        String filePath = "";
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension();
            byte[] data = pic.getData();
            //文件上传七牛
//            QiNiuUtils.uploadOneObject(data,"111_"+picName + "." + ext);
            //图片保存路径
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            //filePath = "D:\\img\\" + picName+"."+df.format(new Date())+ "." + ext;

            filePath = "/root/img/" + picName + "." + df.format(new Date()) + "." + ext;
            System.out.println(filePath);
            FileOutputStream out = new FileOutputStream(filePath);
            out.write(data);
            out.close();
        }
    }
}
