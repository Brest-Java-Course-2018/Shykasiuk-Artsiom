package com.epam.brest.course.dao;

import com.epam.brest.course.model.dto.DepartmentDTO;
import com.epam.brest.course.model.dto.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;

import java.util.Collection;

/**
 * Departmen DAO Interface.
 */
public interface DepartmentDao {

    /**
     * Get list of departments.
     *
     * @return List of objects Department.
     */
    Collection<Department> getDepartments();

    /**
     * Get list of departments.
     *
     * @return Short list of objects Department.
     */
    Collection<ShortDepartmentDTO> getShortDepartmentsDTO();

    /**
     * Get list of departments.
     *
     * @return List of objects Department.
     */
    Collection<DepartmentDTO> getDepartmentsDTO();

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
