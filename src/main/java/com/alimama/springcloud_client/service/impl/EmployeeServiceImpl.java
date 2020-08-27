package com.alimama.springcloud_client.service.impl;


import com.alimama.springcloud_client.mapper.EmployeeMapper;
import com.alimama.springcloud_client.model.Employee;
import com.alimama.springcloud_client.model.EmployeeExample;
import com.alimama.springcloud_client.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PengWX on 2018/12/24.
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Integer saveEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    @Cacheable(value = "employeeService")
    public Employee selectEmployee(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeMapper.selectByExample(new EmployeeExample());
    }

    @Override
    public Integer deleteById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    @Cacheable(value = "employeeService")
    public List<Employee> selectByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }
}
