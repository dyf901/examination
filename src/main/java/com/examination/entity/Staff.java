package com.examination.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Staff" , description = "员工对象")
public class Staff {
    @ApiModelProperty(value = "员工id" , name = "id")
    private int id;

    @ApiModelProperty(value = "年龄" , name = "staff_age")
    private String staff_age;

    @ApiModelProperty(value = "姓名" , name = "staff_name")
    private String staff_name;

    @ApiModelProperty(value = "照片" , name = "staff_img")
    private String staff_img;

    @ApiModelProperty(value = "性别" , name = "staff_sex")
    private String staff_sex;

    @ApiModelProperty(value = "民族" , name = "staff_nation")
    private String staff_nation;

    @ApiModelProperty(value = "身份证号" , name = "staff_card")
    private String staff_card;

    @ApiModelProperty(value = "身份证地址" , name = "staff_address")
    private String staff_address;

    @ApiModelProperty(value = "省份" , name = "staff_province")
    private String staff_province;

    @ApiModelProperty(value = "手机号" , name = "staff_phone")
    private String staff_phone;

    @ApiModelProperty(value = "工种" , name = "worktype")
    private String worktype;

    @ApiModelProperty(value = "入职时间" , name = "entry_time")
    private String entry_time;

    @ApiModelProperty(value = "密码" , name = "password")
    private String password;

    @ApiModelProperty(value = "在职状态('0' 离职  '1'在职)" , name = "state")
    private String state;

    @ApiModelProperty(value = "培训状态('0' 未培训  '1'培训)" , name = "train")
    private String train;

    public Staff() {
        super();
    }

    public Staff(int id, String staff_age, String staff_name, String staff_img, String staff_sex, String staff_nation, String staff_card, String staff_address, String staff_province, String staff_phone, String worktype, String entry_time, String password, String state, String train) {
        this.id = id;
        this.staff_age = staff_age;
        this.staff_name = staff_name;
        this.staff_img = staff_img;
        this.staff_sex = staff_sex;
        this.staff_nation = staff_nation;
        this.staff_card = staff_card;
        this.staff_address = staff_address;
        this.staff_province = staff_province;
        this.staff_phone = staff_phone;
        this.worktype = worktype;
        this.entry_time = entry_time;
        this.password = password;
        this.state = state;
        this.train = train;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaff_age() {
        return staff_age;
    }

    public void setStaff_age(String staff_age) {
        this.staff_age = staff_age;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_img() {
        return staff_img;
    }

    public void setStaff_img(String staff_img) {
        this.staff_img = staff_img;
    }

    public String getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }

    public String getStaff_nation() {
        return staff_nation;
    }

    public void setStaff_nation(String staff_nation) {
        this.staff_nation = staff_nation;
    }

    public String getStaff_card() {
        return staff_card;
    }

    public void setStaff_card(String staff_card) {
        this.staff_card = staff_card;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    public String getStaff_province() {
        return staff_province;
    }

    public void setStaff_province(String staff_province) {
        this.staff_province = staff_province;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", staff_age=" + staff_age +
                ", staff_name='" + staff_name + '\'' +
                ", staff_img='" + staff_img + '\'' +
                ", staff_sex='" + staff_sex + '\'' +
                ", staff_nation='" + staff_nation + '\'' +
                ", staff_card='" + staff_card + '\'' +
                ", staff_address='" + staff_address + '\'' +
                ", staff_province='" + staff_province + '\'' +
                ", staff_phone='" + staff_phone + '\'' +
                ", worktype='" + worktype + '\'' +
                ", entry_time='" + entry_time + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", train='" + train + '\'' +
                '}';
    }

}
