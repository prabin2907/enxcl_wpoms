package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.models.entities.DeptEmpMaster;

public interface IDeptEmpService {

    public ResponseEntity<List<DeptEmpMaster>> getDetails(int id);
    public ResponseEntity<List<Object[]>> getEmployeesByDeptName(String deptName);
    public ResponseEntity<List<Object[]>> getEmployeeWithDepartmentsByName(String empName); 
}
