package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Ttype" , description = "培训类型")
public class Ttype {
    @ApiModelProperty(value = "ID" , name = "id")
    private int id;

    @ApiModelProperty(value = "类型名称" , name = "type_name")
    private String type_name;

    public Ttype() {
        super();
    }

    public Ttype(int id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
