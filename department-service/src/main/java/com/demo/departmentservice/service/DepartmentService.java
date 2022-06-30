package com.demo.departmentservice.service;


import com.demo.departmentservice.entity.Department;
import com.demo.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findDepartmentByDepartmentId(id);
    }

    public List<Department> saveListOfDepartments(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentByDepartmentId(Long departmentId) {
        log.info("In findDepartmentByDepartmentId");
        return departmentRepository.findDepartmentByDepartmentId(departmentId);
    }
}
