package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "TrainRecord" , description = "培训记录")
public class TrainRecord {
    @ApiModelProperty(value = "培训记录id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "考试人员" , name = "staff_name")
    private String staff_name;

    @ApiModelProperty(value = "培训内容" , name = "train_name")
    private String train_name;

    @ApiModelProperty(value = "上传时间" , name = "uptime")
    private String uptime;

    @ApiModelProperty(value = "员工图片" , name = "staff_img")
    private String Staff_img;

    public TrainRecord() {
        super();
    }

    public TrainRecord(int id, int user_id, String staff_name, String train_name, String uptime, String staff_img) {
        this.id = id;
        this.user_id = user_id;
        this.staff_name = staff_name;
        this.train_name = train_name;
        this.uptime = uptime;
        Staff_img = staff_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getStaff_img() {
        return Staff_img;
    }

    public void setStaff_img(String staff_img) {
        Staff_img = staff_img;
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
                ", staff_name='" + staff_name + '\'' +
                ", train_name='" + train_name + '\'' +
                ", uptime='" + uptime + '\'' +
                ", Staff_img='" + Staff_img + '\'' +
                '}';
    }
}
