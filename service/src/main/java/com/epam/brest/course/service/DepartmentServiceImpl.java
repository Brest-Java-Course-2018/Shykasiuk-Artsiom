package com.epam.brest.course.service;

import com.epam.brest.course.dao.DepartmentDao;
import com.epam.brest.course.model.dto.DepartmentDTO;
import com.epam.brest.course.model.dto.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;


/**
 * Departmen Service.
 */
public class DepartmentServiceImpl implements DepartmentService {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * DepartmentDao.
     */
    private DepartmentDao departmentDao;

    /**
     * Constructor.
     *
     * @param departmentDao new departmentDao.
     */
    public DepartmentServiceImpl(final DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department getDepartmentById(final Integer departmentId) {
        LOGGER.debug("getDepartmentById({})", departmentId);
        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public void updateDepartmentDescription(
            final Integer departmentId, final String description) {
        LOGGER.debug("updateDepartmentDescription({}, {})",
                departmentId, description);
        Department department = departmentDao.getDepartmentById(departmentId);
        department.setDescription(description);
        departmentDao.updateDepartment(department);
    }

    @Override
    public Collection<ShortDepartmentDTO> getShortDepartmentsDTO() {
        LOGGER.debug("getShortDepartmentsDTO()");
        return departmentDao.getShortDepartmentsDTO();
    }

    @Override
    public Collection<DepartmentDTO> getDepartmentsDTO() {
        LOGGER.debug("getDepartmentsDTO()");
        return departmentDao.getDepartmentsDTO();
    }

    @Override
    public Collection<Department> getDepartments() {
        return departmentDao.getDepartments();
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentDao.deleteDepartmentById(id);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }
}
