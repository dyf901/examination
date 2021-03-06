package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "train" , description = "培训对象")
public class Train {
    @ApiModelProperty(value = "ID" , name = "id")
    private int id;

    @ApiModelProperty(value = "用户id" , name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "培训类型id" , name = "Ttype_id")
    private int Ttype_id;

    @ApiModelProperty(value = "培训名称" , name = "train_name")
    private String train_name;

    @ApiModelProperty(value = "培训类型名称" , name = "type_name")
    private String type_name;

    @ApiModelProperty(value = "内容" , name = "content")
    private String content;

    @ApiModelProperty(value = "内容" , name = "img")
    private String img;

    @ApiModelProperty(value = "视频地址" , name = "video_url")
    private String video_url;

    @ApiModelProperty(value = "我的培训类型名称",name = "Ttype_name")
    private String Ttype_name;

    public Train() {
        super();
    }

    public Train(int id, int user_id, int ttype_id, String train_name, String type_name, String content, String img, String video_url, String ttype_name) {
        this.id = id;
        this.user_id = user_id;
        Ttype_id = ttype_id;
        this.train_name = train_name;
        this.type_name = type_name;
        this.content = content;
        this.img = img;
        this.video_url = video_url;
        Ttype_name = ttype_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTtype_id() {
        return Ttype_id;
    }

    public void setTtype_id(int ttype_id) {
        Ttype_id = ttype_id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
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
                ", Ttype_id=" + Ttype_id +
                ", train_name='" + train_name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", video_url='" + video_url + '\'' +
                ", Ttype_name='" + Ttype_name + '\'' +
                '}';
    }
}
