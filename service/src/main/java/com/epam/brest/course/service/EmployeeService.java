package com.epam.brest.course.service;

import com.epam.brest.course.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Employee Service Interface.
 */
@Service
public interface EmployeeService {

    /**
     * Get list of employees.
     *
     * @return Collection of objects Employee.
     */
    Collection<Employee> getEmployees();

    /**
     * Get employee.
     *
     * @param employeeId employee number.
     * @return Employee.
     */
    Employee getEmployeeById(Integer employeeId);
}
