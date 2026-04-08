package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.models.entities.EmployeeMaster;
import com.example.demo.models.payloads.EmpMasterPayload;
import com.example.demo.models.responses.EmpMasterResponse;

public interface IEmployeeService {

    public List<EmpMasterResponse> getAllEmployees();
    public ResponseEntity<String> addEmployee(EmpMasterPayload emp);
    public ResponseEntity<EmployeeMaster> updateEmployee(int id, EmployeeMaster emp);
    public String delEmployee(int id);
    public ResponseEntity<EmployeeMaster> getOneEmployee(int id);

}
