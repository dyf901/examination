package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Ttype" , description = "培训类型")
public class Ttype {
    @ApiModelProperty(value = "ID" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "类型名称" , name = "Ttype_name")
    private String Ttype_name;

    public Ttype() {
        super();
    }

    public Ttype(int id, int user_id, String ttype_name) {
        this.id = id;
        this.user_id = user_id;
        Ttype_name = ttype_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTtype_name() {
        return Ttype_name;
    }

    public void setTtype_name(String ttype_name) {
        Ttype_name = ttype_name;
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
                ", Ttype_name='" + Ttype_name + '\'' +
                '}';
    }
}
