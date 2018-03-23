package com.epam.brest.course.service;

import com.epam.brest.course.model.dto.DepartmentDTO;
import com.epam.brest.course.model.dto.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Departmen Service Interface.
 */
@Service
public interface DepartmentService {

    /**
     * Get department.
     *
     * @param departmentId department number.
     * @return Department.
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Update department.
     *
     * @param departmentId new version of old department.
     * @param description new description.
     */
    void updateDepartmentDescription(Integer departmentId, String description);

    /**
     * Get list of ShortDepartmentDTO.
     *
     * @return Collection of objects ShortDepartmentDTO.
     */
    Collection<ShortDepartmentDTO> getShortDepartmentsDTO();

    /**
     * Get list of departmentsDTO.
     *
     * @return Collection of objects DepartmentDTO.
     */
    Collection<DepartmentDTO> getDepartmentsDTO();

    Collection<Department> getDepartments();
    /**
     * Delete department.
     *
     * @param id what department to remove.
     */
    void deleteDepartmentById(Integer id);
    Department addDepartment(Department department);
}
