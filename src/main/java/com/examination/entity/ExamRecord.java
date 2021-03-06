package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "exam_record" , description = "考试记录表对象")
public class ExamRecord {
    @ApiModelProperty(value = "考试记录id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "考试id" , name = "exam_id")
    private int exam_id;

    @ApiModelProperty(value = "考试名称" , notes = "exam_name")
    private String exam_name;

    @ApiModelProperty(value = "员工id" , name = "staff_id")
    private int staff_id;

    @ApiModelProperty(value = "考试名称" , notes = "staff_name")
    private String staff_name;

    @ApiModelProperty(value = "考试分数" , name = "exam_count")
    private int exam_count;

    @ApiModelProperty(value = "考试时间" , name = "exam_time")
    private String exam_time;

    @ApiModelProperty(value = "考试结果" , name = "exam_result")
    private String exam_result;

    @ApiModelProperty(value = "考试时间戳" , name = "exam_timeC")
    private Long exam_timeC;

    public ExamRecord() {
        super();
    }

    public ExamRecord(int id, int user_id, int exam_id, String exam_name, int staff_id, String staff_name, int exam_count, String exam_time, String exam_result, Long exam_timeC) {
        this.id = id;
        this.user_id = user_id;
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.exam_count = exam_count;
        this.exam_time = exam_time;
        this.exam_result = exam_result;
        this.exam_timeC = exam_timeC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getExam_count() {
        return exam_count;
    }

    public void setExam_count(int exam_count) {
        this.exam_count = exam_count;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public String getExam_result() {
        return exam_result;
    }

    public void setExam_result(String exam_result) {
        this.exam_result = exam_result;
    }

    public Long getExam_timeC() {
        return exam_timeC;
    }

    public void setExam_timeC(Long exam_timeC) {
        this.exam_timeC = exam_timeC;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", exam_id=" + exam_id +
                ", exam_name='" + exam_name + '\'' +
                ", staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", exam_count=" + exam_count +
                ", exam_time='" + exam_time + '\'' +
                ", exam_result='" + exam_result + '\'' +
                ", exam_timeC=" + exam_timeC +
                '}';
    }
}
