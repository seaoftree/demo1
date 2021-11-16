package com.example.demo1.dynamic_proxy;

import lombok.Data;

import java.util.List;

@Data
class AttendeeParam {

    // 群组id
    private List<String> groupIds;
    // 部门id
    private List<String> depIds;
    // 员工id
    private List<String> bspIds;
}