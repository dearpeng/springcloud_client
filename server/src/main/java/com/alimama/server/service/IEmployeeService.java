package com.alimama.server.service;


import com.alimama.server.model.Employee;
import com.alimama.server.model.EmployeeExample;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
public interface IEmployeeService {

    Integer saveEmployee(Employee employee);

    Employee selectEmployee(Integer id);

    List<Employee> getAllEmployeeList();

    Integer deleteById(Integer id);

    Integer updateEmployee(Employee employee);

    List<Employee> selectByExample(EmployeeExample example);
}
