package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "User", description = "用户表对象")
public class User {
    @ApiModelProperty(value = "用户id", name = "id")
    private int id;

    @ApiModelProperty(value = "账号", name = "username")
    private String username;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "创建时间", name = "create_time")
    private String create_time;

    @ApiModelProperty(value = "到期时间", name = "end_time")
    private String end_time;

    @ApiModelProperty(value = "站点名称", name = "station_name")
    private String station_name;

    public User(){
        super();
    }

    public User(int id, String username, String password, String create_time, String end_time, String station_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.create_time = create_time;
        this.end_time = end_time;
        this.station_name = station_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_time='" + create_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", station_name='" + station_name + '\'' +
                '}';
    }
}
