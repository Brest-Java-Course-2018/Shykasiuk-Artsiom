package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml", "classpath:dao.xml"})
@Rollback
@Transactional

public class EmployeeDaoImplTest {

    @Autowired EmployeeDao employeeDao;

    @Test
    public void getEmployees() {
        List<Employee> employees = employeeDao.getEmployees();
        Assert.assertFalse(employees.isEmpty());
    }

    @Test
    public void getEmployeeById(){
        Employee employee = employeeDao.getEmployeeById(1);
        Assert.assertNotNull(employee);
        Assert.assertTrue(employee.getEmployeeId().equals(1));
        Assert.assertTrue(employee.getDepartmentId().equals(1));
        Assert.assertTrue(
                employee.getEmployeeName().equals("Vasya"));
        Assert.assertTrue(
                employee.getSalary().equals(1000));
    }

    @Test
    public void getEmployeeByDepartment(){
        List<Employee> employees = employeeDao.getEmployeesByDepartment(1);
        employees.forEach(employee -> Assert.assertTrue(employee.getDepartmentId().equals(1)));
    }

    @Test
    public void addEmployee(){
        List<Employee> employees = employeeDao.getEmployees();
        int sizeBefore = employees.size();
        Employee employee =
                new Employee("Yahor", 500, 2);
        Employee newemployee = employeeDao.addEmployee(employee);
        Assert.assertNotNull(newemployee.getEmployeeId());
        Assert.assertTrue(newemployee.getEmployeeName().equals(employee.getEmployeeName()));
        Assert.assertTrue(newemployee.getSalary().equals(employee.getSalary()));
        Assert.assertTrue(newemployee.getDepartmentId().equals(employee.getDepartmentId()));
        Assert.assertTrue(sizeBefore + 1 == employeeDao.getEmployees().size());
    }

    @Test
    public void updateEmployee(){
        Employee employee =
                new Employee("Yahor", 500, 2);
        Employee newEmployee = employeeDao.addEmployee(employee);
        newEmployee.setEmployeeName("Yagor");
        newEmployee.setSalary(300);

        employeeDao.updateEmployee(newEmployee);
        Employee updatedEmployee = employeeDao.getEmployeeById(newEmployee.getEmployeeId());
        Assert.assertTrue(newEmployee.getEmployeeId().equals(updatedEmployee.getEmployeeId()));
        Assert.assertTrue(newEmployee.getDepartmentId().equals(updatedEmployee.getDepartmentId()));
        Assert.assertTrue(newEmployee.getSalary().equals(updatedEmployee.getSalary()));
        Assert.assertTrue(newEmployee.getEmployeeName().equals((updatedEmployee.getEmployeeName())));
    }

    @Test
    public void deleteEmployee(){
        Employee employee =
                new Employee("Jack", 1000, 1);
        employee = employeeDao.addEmployee(employee);

        List<Employee> employees = employeeDao.getEmployees();
        int sizeBefore = employees.size();
        employeeDao.deleteEmployeeById(employee.getEmployeeId());
        Assert.assertTrue((sizeBefore-1) == employeeDao.getEmployees().size());
    }
}
