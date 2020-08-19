package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Worktype" , description = "工种表对象")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Worktype {
    @ApiModelProperty(value = "考试id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "发布时间" , name = "worktype_name")
    private String worktype_name;

    @ApiModelProperty(value = "发布时间" , name = "content")
    private String content;

    @ApiModelProperty(value = "发布时间" , name = "remark")
    private String remark;

    public Worktype(){
        super();
    }

    public Worktype(int id, int user_id, String worktype_name, String content, String remark) {
        this.id = id;
        this.user_id = user_id;
        this.worktype_name = worktype_name;
        this.content = content;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorktype_name() {
        return worktype_name;
    }

    public void setWorktype_name(String worktype_name) {
        this.worktype_name = worktype_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                ", worktype_name='" + worktype_name + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
