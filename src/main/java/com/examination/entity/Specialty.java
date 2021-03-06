package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "specialty" , description = "专业表对象")
    public class Specialty {
    @ApiModelProperty(value = "专业id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "专业名称" , name = "specialty_name")
    private String specialty_name;

    public Specialty() {
        super();
    }

    public Specialty(int id, int user_id, String specialty_name) {
        this.id = id;
        this.user_id = user_id;
        this.specialty_name = specialty_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialty_name() {
        return specialty_name;
    }

    public void setSpecialty_name(String specialty_name) {
        this.specialty_name = specialty_name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", specialty_name='" + specialty_name + '\'' +
                '}';
    }
}
