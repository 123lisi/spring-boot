package com.test.day01.controller;

import com.test.day01.dao.DepartmentDao;
import com.test.day01.dao.EmployeeDao;
import com.test.day01.entities.Department;
import com.test.day01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    //在增加员工信息页面获取部门名称的url
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        //放在请求域中
        model.addAttribute("departs",departments);
        //添加页面
        return "emp/add";
    }
    //增加员工信息功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        System.out.println(employee);
        //来到员工页面
        employeeDao.save(employee);
//        System.out.println("POST");
        //redirect:表示重定向到一个地址
        //forward 表示转发到一个地址
        return "redirect:/emps";
    }
    //编辑信息功能
    @GetMapping("/emp/{id}")
    public String editorEmp(@PathVariable(value = "id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        //放在请求域中
        model.addAttribute("departs",departments);
        return "emp/add";
    }
    //修改信息的路由
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
//        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除信息功能
    @GetMapping("/del/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id){
        //删除信息的方法
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
