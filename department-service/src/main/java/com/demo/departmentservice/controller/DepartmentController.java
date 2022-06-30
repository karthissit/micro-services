package com.demo.departmentservice.controller;

import com.demo.departmentservice.entity.Department;
import com.demo.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/greet")
    public String sayHello(){
        return "Hello, Welcome to the Department Service!";
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        Department dept = departmentService.saveDepartment(department);
        log.info("Saving Department: " + dept);
        return dept;
    }
    @PostMapping("/dpts")
    public List<Department> saveDepartments(@RequestBody List<Department> departments){
        List<Department> depts = departmentService.saveListOfDepartments(departments);
        log.info("Saving Departments: " + depts);
        return depts;
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id){
        Department dept = departmentService.findDepartmentById(id);
        log.info("Getting Department: " + dept);
        return dept;
    }

    @GetMapping("/getall")
    public List<Department> getAllDepartments(){
        List<Department> depts = departmentService.findAll();
        log.info("Getting all departments: " + depts);
        return depts;
    }

    @GetMapping("/getDept/{id}")
    public Department getDepartmentByDepartmentId(@PathVariable("id") Long departmentId){
        return departmentService.findDepartmentByDepartmentId(departmentId);
    }
}
