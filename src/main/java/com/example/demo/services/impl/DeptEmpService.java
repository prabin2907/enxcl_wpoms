package com.example.demo.services.impl;

import java.util.List;

import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.DeptEmpMaster;
import com.example.demo.repository.DeptEmpRepository;
import com.example.demo.services.IDeptEmpService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class DeptEmpService implements IDeptEmpService{

    private final DeptEmpRepository _deptEmpRepository;
    public DeptEmpService(DeptEmpRepository _deptEmpRepository){
        this._deptEmpRepository=_deptEmpRepository;
    }

    @Override
    public ResponseEntity<List<DeptEmpMaster>> getDetails(int id) {
            List<DeptEmpMaster> details = _deptEmpRepository.findByDeptId(id);
            return ResponseEntity.ok(details);
    }

    @Override
    public ResponseEntity<List<Object[]>> getEmployeesByDeptName(String deptName) {
       
        List<Object[]> employees = _deptEmpRepository.findEmployeesByDepartmentName(deptName);
        return ResponseEntity.ok(employees);
        
    }

    @Override
    public ResponseEntity<List<Object[]>> getEmployeeWithDepartmentsByName(String empName) {

        List<Object[]> results = _deptEmpRepository.findEmployeeWithDepartmentsByName(empName);
        return ResponseEntity.ok(results);
        
    }

    public void display()
    {
        System.out.println("Hello World");
    }

}
