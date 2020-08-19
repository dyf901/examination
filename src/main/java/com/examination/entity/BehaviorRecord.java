package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
行为记录实体类
behavior_record   行为记录表
id   					行为记录id
staff_id   				员工id
behavior_id   			行为id
section_id              标段id
station_id              站点id
uptime   				上传时间
remark   				备注

staff_name              员工姓名
behavior_name           行为名称
section_name            标段名称
station_name              站点名称
*/
@ApiModel(value = "BehaviorRecord", description = "行为记录对象")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BehaviorRecord {
    @ApiModelProperty(value = "行为记录id", name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "员工id", name = "staff_id")
    private int staff_id;

    @ApiModelProperty(value = "行为类型id", name = "behavior_id")
    private int behavior_id;

    @ApiModelProperty(value = "上传时间", name = "uptime")
    private String uptime;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "员工姓名", name = "staff_name")
    private String staff_name;

    @ApiModelProperty(value = "行为类型名称", name = "behavior_name")
    private String behavior_name;

    public BehaviorRecord() {
        super();
    }

    public BehaviorRecord(int id, int user_id, int staff_id, int behavior_id, String uptime, String remark, String staff_name, String behavior_name) {
        this.id = id;
        this.user_id = user_id;
        this.staff_id = staff_id;
        this.behavior_id = behavior_id;
        this.uptime = uptime;
        this.remark = remark;
        this.staff_name = staff_name;
        this.behavior_name = behavior_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getBehavior_id() {
        return behavior_id;
    }

    public void setBehavior_id(int behavior_id) {
        this.behavior_id = behavior_id;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getBehavior_name() {
        return behavior_name;
    }

    public void setBehavior_name(String behavior_name) {
        this.behavior_name = behavior_name;
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
                ", staff_id=" + staff_id +
                ", behavior_id=" + behavior_id +
                ", uptime='" + uptime + '\'' +
                ", remark='" + remark + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", behavior_name='" + behavior_name + '\'' +
                '}';
    }
}
