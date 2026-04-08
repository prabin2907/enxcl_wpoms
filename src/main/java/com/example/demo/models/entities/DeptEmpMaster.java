package com.example.demo.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dept_emp")
public class DeptEmpMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_emp_id")
    private Long deptEmpId;

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "dept_id")
    private Long deptId;

    public Long getDeptEmpId() {
        return deptEmpId;
    }
    public void setDeptEmpId(Long deptEmpId) {
        this.deptEmpId = deptEmpId;
    }
    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public Long getDeptId() {
        return deptId;
    }
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
    
}
