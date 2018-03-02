package com.epam.brest.course.model;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName("Vasia");
        Assert.assertEquals("Vasia", employee.getEmployeeName());

    }
}