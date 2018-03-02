package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml"})
public class DepartmentDaoImplTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void getDepartments() {
        List<Department> departments = departmentDao.getDepartments();
        Assert.assertFalse(departments.isEmpty());
    }

    @Test
    public void getDepartmentById() {
        Department department = departmentDao.getDepartmentById(1);
        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentId().equals(1));
        Assert.assertTrue(
                department.getDepartmentName().equals("Distribution"));
        Assert.assertTrue(
                department.getDescription().equals("Distribution Department"));
    }

    @Test
    public void addDepartment() {
        final String DEP_NAME = "Management";
        final String DEP_DESCR = "Management Department";

        Department department = new Department();
        department.setDepartmentName(DEP_NAME);
        department.setDescription(DEP_DESCR);
        Department addedDepartment = departmentDao.addDepartment(department);

        Assert.assertNotNull(addedDepartment);
        Assert.assertTrue(addedDepartment.getDepartmentName().equals(DEP_NAME));
        Assert.assertTrue(addedDepartment.getDescription().equals(DEP_DESCR));
    }

    @Test
    public void updateDepartment() {
        Department department = new Department();
        department.setDepartmentId(2);
        department.setDepartmentName("Supp");
        department.setDescription("Support Team");

        departmentDao.updateDepartment(department);
        Department updatedDepartment = departmentDao.getDepartmentById(2);

        Assert.assertNotNull(updatedDepartment);
        Assert.assertEquals(department, updatedDepartment);
    }


    @Test
    public void deleteDepartmentById() {
        departmentDao.deleteDepartmentById(3);
        Department department = departmentDao.getDepartmentById(3);
        Assert.assertTrue(department == null);
    }
}