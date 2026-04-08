package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entities.DeptEmpMaster;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmpMaster, Long>{
    List<DeptEmpMaster> findByDeptId(int id);

    @Query(value = "SELECT e.full_name, e.address, e.salary, d.dept_name " +
                   "FROM employees e " +
                   "INNER JOIN dept_emp de ON e.id = de.emp_id " +
                   "INNER JOIN department d ON de.dept_id = d.dept_id " +
                   "WHERE d.dept_name = :deptName", nativeQuery = true)
    List<Object[]> findEmployeesByDepartmentName(@Param("deptName") String deptName);

    @Query(value = "SELECT e.id, e.full_name, e.address, e.salary, d.dept_name " +
                   "FROM employees e " +
                   "INNER JOIN dept_emp de ON e.id = de.emp_id " +
                   "INNER JOIN department d ON de.dept_id = d.dept_id " +
                   "WHERE UPPER(e.full_name) LIKE UPPER(CONCAT('%', :empName, '%'))", 
           nativeQuery = true)
    List<Object[]> findEmployeeWithDepartmentsByName(@Param("empName") String empName);
}
