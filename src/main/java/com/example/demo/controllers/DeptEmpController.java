package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.DeptEmpMaster;
import com.example.demo.services.IDeptEmpService;

@RestController
@RequestMapping("/api")
public class DeptEmpController {

    private final IDeptEmpService _deptEmpService;

    public DeptEmpController(IDeptEmpService _deptEmpService){
        this._deptEmpService=_deptEmpService;
    }

    @GetMapping("/dept-emp")
    public ResponseEntity<List<DeptEmpMaster>> getDetails(@RequestParam int id){
        return _deptEmpService.getDetails(id);
    }

    @GetMapping("/dept-emp/by-dept-name")
    public ResponseEntity<List<Object[]>> getEmployeesByDeptName(@RequestParam String name){
        return _deptEmpService.getEmployeesByDeptName(name);
    }

    @GetMapping("/dept-emp/by-emp-name")
    public ResponseEntity<List<Object[]>> getEmployeeWithDepartmentsByName(@RequestParam String name){
        return _deptEmpService.getEmployeeWithDepartmentsByName(name);
    }
}
