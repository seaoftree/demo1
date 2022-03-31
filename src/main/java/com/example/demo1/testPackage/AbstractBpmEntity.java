package com.example.demo1.testPackage;

public class AbstractBpmEntity {

    // TOKEN
    String token;

    // 申请人（拼接）
    String applicantName;

    // 提单用户姓名
    private String submitUserName;

    // 申请人部门
    String applicantDept;

    // 申请日期
    String applicantDate;

    // 工单号
    String p_number;

    // sn号
    String p_process_sn;

    // 真名
    String user_name;

    // 用户id
    String user_id;

    // 真实名字
    String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public String getApplicantDept() {
        return applicantDept;
    }

    public void setApplicantDept(String applicantDept) {
        this.applicantDept = applicantDept;
    }

    public String getApplicantDate() {
        return applicantDate;
    }

    public void setApplicantDate(String applicantDate) {
        this.applicantDate = applicantDate;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }

    public String getP_process_sn() {
        return p_process_sn;
    }

    public void setP_process_sn(String p_process_sn) {
        this.p_process_sn = p_process_sn;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
