package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "knowledge" , description = "知识表对象")
public class Knowledge {
    @ApiModelProperty(value = "题目id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "知识名称" , name = "knowledge_name")
    private String knowledge_name;

    public Knowledge() {
        super();
    }

    public Knowledge(int id, String knowledge_name) {
        this.id = id;
        this.knowledge_name = knowledge_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnowledge_name() {
        return knowledge_name;
    }

    public void setKnowledge_name(String knowledge_name) {
        this.knowledge_name = knowledge_name;
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
                ", knowledge_name='" + knowledge_name + '\'' +
                '}';
    }
}
