package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml", "classpath:dao.xml"})
@Rollback
@Transactional
public class DepartmentDaoImplTest {

    public static final String DISTRIBUTION = "Distribution";
    public static final String DISTRIBUTION_DEPARTMENT = "Distribution Department";
    public static final String EDUCATION_AND_TRAINING = "Education and Training";
    public static final String DEPARTMENT_OF_EDUCATION_AND_TRAINING = "Department of Education and Training";
    public static final String DEPARTMENT_WITH_THE_SAME_NAME_ALREADY_EXISTS = "Department with the same name already exists";
    public static final String EDUCATION = "Education";
    public static final String DEPARTMENT_OF_EDUCATION = "Department of Education";
    public static final String NEW_EDUCATION = "NEW Education";
    public static final String NEW_DEPARTMENT_OF_EDUCATION = "NEW Department of Education";
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void getDepartments() {
        Collection<Department> departments = departmentDao.getDepartments();
        Assert.assertFalse(departments.isEmpty());
    }

    @Test
    public void getDepartmentById() {
        Department department = departmentDao.getDepartmentById(1);
        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentId().equals(1));
        Assert.assertTrue(department.getDepartmentName().equals(DISTRIBUTION));
        Assert.assertTrue(
                department.getDescription().equals(DISTRIBUTION_DEPARTMENT));
    }

    @Test
    public void addDepartment() {
        Collection<Department> departments = departmentDao.getDepartments();
        int sizeBefore = departments.size();
        Department department = new Department(EDUCATION_AND_TRAINING,
                DEPARTMENT_OF_EDUCATION_AND_TRAINING);
        Department newDepartment = departmentDao.addDepartment(department);

        Assert.assertNotNull(newDepartment);
        Assert.assertTrue(newDepartment.getDepartmentName().equals(
                department.getDepartmentName()));
        Assert.assertTrue(newDepartment.getDescription().equals(
                department.getDescription()));
        Assert.assertTrue(
                sizeBefore + 1 == departmentDao.getDepartments().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSameDepartment() {
        Department department = new Department(EDUCATION_AND_TRAINING,
                DEPARTMENT_OF_EDUCATION_AND_TRAINING);
        departmentDao.addDepartment(department);
        departmentDao.addDepartment(department);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addSameDepartmentWithRule() {
        Department department = new Department(EDUCATION_AND_TRAINING,
                DEPARTMENT_OF_EDUCATION_AND_TRAINING);
        departmentDao.addDepartment(department);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(DEPARTMENT_WITH_THE_SAME_NAME_ALREADY_EXISTS);
        departmentDao.addDepartment(department);
    }

    @Test
    public void updateDepartment() {
        Department department =
                new Department(EDUCATION, DEPARTMENT_OF_EDUCATION);
        Department newDepartment = departmentDao.addDepartment(department);
        newDepartment.setDepartmentName(NEW_EDUCATION);
        newDepartment.setDescription(NEW_DEPARTMENT_OF_EDUCATION);
        departmentDao.updateDepartment(newDepartment);
        Department updateDepartment = departmentDao.getDepartmentById(
                newDepartment.getDepartmentId());

        Assert.assertTrue(newDepartment.getDepartmentId() ==
                updateDepartment.getDepartmentId());
        Assert.assertTrue(newDepartment.getDepartmentName().equals(
                updateDepartment.getDepartmentName()));
        Assert.assertTrue(newDepartment.getDescription().equals(
                updateDepartment.getDescription()));

    }


    @Test
    public void deleteDepartmentById() {
        Department department =
                new Department(EDUCATION, DEPARTMENT_OF_EDUCATION);
        department = departmentDao.addDepartment(department);
        Collection<Department> departments = departmentDao.getDepartments();
        int sizeBefore = departments.size();
        departmentDao.deleteDepartmentById(department.getDepartmentId());

        Assert.assertTrue(sizeBefore - 1 == departmentDao.getDepartments().size());
    }
}
