package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
行为记录实体类
behavior        行为类型表
id   					行为id
behavior_name   		行为名称
section_id              标段id
detail   				详细
remark   				备注

section_name            标段名称

*/
@ApiModel(value = "Behavior" , description = "行为类型对象")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Behavior {
    @ApiModelProperty(value = "员工id" , name = "id")
    private int id;

    @ApiModelProperty(value = "行为类型名称" , name = "behavior_name")
    private String behavior_name;

    @ApiModelProperty(value = "详细" , name = "detail")
    private String detail;

    @ApiModelProperty(value = "备注" , name = "remark")
    private String remark;

    public Behavior(){
        super();
    }

    public Behavior(int id, String behavior_name, String detail, String remark) {
        this.id = id;
        this.behavior_name = behavior_name;
        this.detail = detail;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBehavior_name() {
        return behavior_name;
    }

    public void setBehavior_name(String behavior_name) {
        this.behavior_name = behavior_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", behavior_name='" + behavior_name + '\'' +
                ", detail='" + detail + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
