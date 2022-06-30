package com.demo.departmentservice.repository;

import com.demo.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //Department findDepartmentById(Long id);

    Department findDepartmentByDepartmentId(Long departmentId);
}
