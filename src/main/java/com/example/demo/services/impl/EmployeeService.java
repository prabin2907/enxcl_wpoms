package com.example.demo.services.impl;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.EmployeeMaster;
import com.example.demo.models.payloads.EmpMasterPayload;
import com.example.demo.models.responses.EmpMasterResponse;
import com.example.demo.repository.EmployeeMasterRepository;
import com.example.demo.services.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{

    private final EmployeeMasterRepository _employeeMasterRepository;
    public EmployeeService(EmployeeMasterRepository _employeeMasterRepository){
        this._employeeMasterRepository=_employeeMasterRepository;
    }

    @Override
    public List<EmpMasterResponse> getAllEmployees(){
       List<EmployeeMaster> response= _employeeMasterRepository.findAll();
       List<EmpMasterResponse> empMasterResponses=new ArrayList<>();
       for(EmployeeMaster e : response){
        EmpMasterResponse empMasterResponse=new EmpMasterResponse();
        empMasterResponse.setAddress(e.getAddress());
        empMasterResponse.setFull_name(e.getFull_name());
        empMasterResponse.setSalary(e.getSalary());
        empMasterResponses.add(empMasterResponse);
       }
       return empMasterResponses;
    }

    @Override
    public ResponseEntity<String> addEmployee(EmpMasterPayload emp){
        EmployeeMaster employeeMaster=new EmployeeMaster();
        employeeMaster.setAddress(emp.getAddress());
        employeeMaster.setFull_name(emp.getFull_name());
        employeeMaster.setSalary(emp.getSalary());
      _employeeMasterRepository.save(employeeMaster);
      return ResponseEntity.ok("Data Entered Successfully");
    }

    @Override
    public ResponseEntity<EmployeeMaster> updateEmployee(int id, EmployeeMaster emp) {
        var upd=_employeeMasterRepository.findById(id).get();
        upd.setFull_name(emp.getFull_name());
        upd.setAddress(emp.getAddress());
        upd.setSalary(emp.getSalary());
        _employeeMasterRepository.save(upd);
        return ResponseEntity.ok(upd);
    }

    @Override
    public String delEmployee(int id){
        _employeeMasterRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public ResponseEntity<EmployeeMaster> getOneEmployee(int id) {
        var getEmp=_employeeMasterRepository.findById(id).get();
        return ResponseEntity.ok(getEmp);
    }
}
