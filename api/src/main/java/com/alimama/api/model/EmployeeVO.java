package com.alimama.api.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.xml.transform.Source;
import java.util.Date;

/**
 * Created by PengWX on 2020/8/29.
 */
@Data
public class EmployeeVO {

    /**
     *
     */
    private Integer id;

    /**
     * 名字
     */
    private String lastName;

    /**
     * 性别(1:男 0:女)
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;
}
