package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;

import java.util.List;

/**
 * Departmen DAO Interface.
 */
public interface DepartmentDao {

    /**
     * Get list of departments.
     *
     * @return List of objects Department
     */
    List<Department> getDepartments();

    /**
     * Get department.
     *
     * @param departmentId department number.
     * @return Department.
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Add new department.
     *
     * @param department new department.
     * @return Department.
     */
    Department addDepartment(Department department);

    /**
     * Update department.
     *
     * @param department new version of old department.
     */
    void updateDepartment(Department department);

    /**
     * Delete department.
     *
     * @param id what department to remove.
     */
    void deleteDepartmentById(Integer id);

}
