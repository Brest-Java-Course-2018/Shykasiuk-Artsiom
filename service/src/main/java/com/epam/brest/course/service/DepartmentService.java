package com.epam.brest.course.service;

import com.epam.brest.course.model.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Department Service Interface.
 */
@Service
public interface DepartmentService {

    Department getDepartmentById(Integer departmentId);

    /**
     * Get list of departments.
     *
     * @return List of objects Department
     */
    Collection<Department> getDepartments();
    void updateDepartmentDescription(Integer departmentId, String description);

}
