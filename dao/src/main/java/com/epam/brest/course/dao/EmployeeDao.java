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
     * @return List of objects Employee.
     */
    List<Employee> getEmployees();

    /**
     * Get employee by department.
     *
     * @param departmentId department number.
     * @return Employee.
     */
    List<Employee> getEmployeeByDepartmentId(Integer departmentId);

    /**
     * Get employee.
     *
     * @param employeeId employee number.
     * @return Employee.
     */
    Employee getEmployeeById(Integer employeeId);

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
     * @param id what employee to remove.
     */
    void deleteEmployeeById(Integer id);


}
