package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Worktype" , description = "工种表对象")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Worktype {
    @ApiModelProperty(value = "考试id" , name = "id")
    private int id;

    @ApiModelProperty(value = "发布时间" , name = "worktype_name")
    private String worktype_name;

    @ApiModelProperty(value = "发布时间" , name = "content")
    private String content;

    @ApiModelProperty(value = "发布时间" , name = "remark")
    private String remark;

    public Worktype(){
        super();
    }

    public Worktype(int id, String worktype_name, String content, String remark) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", worktype_name='" + worktype_name + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
