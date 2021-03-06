package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "TrainContentRecord" , description = "展馆培训记录")
public class TrainContentRecord {
    @ApiModelProperty(value = "展馆培训记录id" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "员工姓名" , name = "name")
    private String name;

    @ApiModelProperty(value = "身份证号" , name = "card")
    private String card;

    @ApiModelProperty(value = "性别" , name = "sex")
    private String sex;

    @ApiModelProperty(value = "年龄" , name = "age")
    private String age;

    @ApiModelProperty(value = "员工照片" , name = "img")
    private String img;

    @ApiModelProperty(value = "上传时间" , name = "uptime")
    private String uptime;

    @ApiModelProperty(value = "培训内容" , name = "content")
    private String content;

    public TrainContentRecord(){
        super();
    }

    public TrainContentRecord(int id, int user_id, String name, String card, String sex, String age, String img, String uptime, String content) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.card = card;
        this.sex = sex;
        this.age = age;
        this.img = img;
        this.uptime = uptime;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
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
                ", name='" + name + '\'' +
                ", card='" + card + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", img='" + img + '\'' +
                ", uptime='" + uptime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
