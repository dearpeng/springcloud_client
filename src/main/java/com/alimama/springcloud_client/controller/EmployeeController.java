package com.alimama.springcloud_client.controller;

import com.alibaba.fastjson.JSON;
import com.alimama.springcloud_client.model.Employee;
import com.alimama.springcloud_client.service.IEmployeeService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.util.Collection;
import java.util.List;

/**
 * Created by PengWX on 2018/12/7.
 */
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("testCloud")
    @ResponseBody
    public String testCloud(){
        return "employee testCloud success";
    }
    /**
     * 获取员工列表
     * @return
     */
    @GetMapping("/emps")
    @ResponseBody
    public String getAllEmps() throws Exception{
//        int a = 1/0;
        Collection<Employee> all = employeeService.getAllEmployeeList();
        return JSON.toJSONString(all);
    }


    /**
     * 员工修改
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 删除emp
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteById(id);
        return "redirect:/emps";
    }

    /**
     * 测试新增
     * @param employee
     * @return
     */
    @RequestMapping("insertEmp")
    public String saveEmp(Employee employee) {
        Integer empId = employeeService.saveEmployee(employee);
        return "redirect:/emps";
    }

    @PostMapping("getEmp")
    @ResponseBody
    public Employee getEmp(Integer id){
        Employee employee = employeeService.selectEmployee(id);
        return employee;
    }
}
