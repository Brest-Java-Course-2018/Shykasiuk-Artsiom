package com.epam.brest.course.dao;


import com.epam.brest.course.model.Employee;

import java.util.List;

/**
 * Employee DAO Interface.
 */

public interface EmployeeDao {


    /**
     * Get list of employees.
     *
     * @return List of objects Employee
     */
    List<Employee> getEmployees();

    /**
     * Get employee.
     *
     * @param employeeId employee number.
     * @return Employee.
     */
    Employee getEmployeeById(Integer employeeId);

    /**
     * Get employees in department.
     *
     * @param departmentId department number
     * @return
     */
    List<Employee> getEmployeesByDepartment(Integer departmentId);

    /**
     * Add new employee.
     *
     * @param employee new employee.
     * @return Employee.
     */
    Employee addEmployee(Employee employee);

    /**
     * Update employee.
     *
     * @param employee new version of old employee.
     */
    void updateEmployee(Employee employee);

    /**
     * Delete employee.
     *
     * @param id which employee to remove.
     */
    void deleteEmployeeById(Integer id);

}
