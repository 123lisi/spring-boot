package com.guoge2.springboot.controller;

import com.guoge2.springboot.bean.Department;
import com.guoge2.springboot.bean.Employee;
import com.guoge2.springboot.mapper.DepartmentMapper;
import com.guoge2.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;
    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }
    @ResponseBody
    @GetMapping("/dept")
    public Department inserDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;

    }
    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
