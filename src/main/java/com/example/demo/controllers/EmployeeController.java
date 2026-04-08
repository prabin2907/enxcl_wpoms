package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.EmployeeMaster;
import com.example.demo.models.payloads.EmpMasterPayload;
import com.example.demo.models.responses.EmpMasterResponse;
import com.example.demo.services.IEmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    
    private final IEmployeeService _employeeService;
    public EmployeeController(IEmployeeService _employeeService){
        this._employeeService=_employeeService;
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<List<EmpMasterResponse>> getEmployee(){
        var response=_employeeService.getAllEmployees();
        return ResponseEntity.ok(response);
    } 
    
    @GetMapping("/get")
    public ResponseEntity<EmployeeMaster> getOneEmployee(@RequestParam int id){
        return _employeeService.getOneEmployee(id);
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmpMasterPayload emp){
        return _employeeService.addEmployee(emp);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeMaster> updateEmployee(@RequestParam int id,@RequestBody EmployeeMaster emp){
        return _employeeService.updateEmployee(id,emp);
    }

    @DeleteMapping("/delete")
    public String delEmployee(@RequestParam int id){
        return _employeeService.delEmployee(id);
    }
}
