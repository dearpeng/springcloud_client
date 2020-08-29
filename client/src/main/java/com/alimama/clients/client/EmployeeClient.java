package com.alimama.clients.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PengWX on 2020/8/29.
 */
@FeignClient(name = "employee")
/*
*  name:当前项目的application,同是也是eureka服务端的application,让其他client能够知道是调用application是employee的服务
* */
public interface EmployeeClient {

    /**
     * 提供给外部调用的接口,requestMapping是这个项目controller中提供给外部的方法.方法名字随意.
     * @return
     */
    @RequestMapping("/employee/emps")
    String getAllEmployee();

}
