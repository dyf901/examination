package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "TrainContentW" , description = "馆内培训内容")
public class TrainContentW {
    @ApiModelProperty(value = "培训内容id" , name = "id")
    private int id;

    @ApiModelProperty(value = "培训名称" , name = "train_name")
    private String train_name;

    @ApiModelProperty(value = "详细介绍" , name = "content")
    private String content;

    @ApiModelProperty(value = "培训图片" , name = "img_url")
    private String img_url;

    public TrainContentW() {
        super();
    }

    public TrainContentW(int id, String train_name, String content, String img_url) {
        this.id = id;
        this.train_name = train_name;
        this.content = content;
        this.img_url = img_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", train_name='" + train_name + '\'' +
                ", content='" + content + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
