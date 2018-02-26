package com.epam.brest.cource;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName("Vasia");
        Assert.assertEquals("Vasia", employee.getEmployeeName());

    }
}