package com.epam.brest.course.model;


/**
 * POJO Employee.
 */
public class Employee {

    /**
     * Property Id.
     */
    private Integer employeeId;

    /**
     * Property Name.
     */
    private String employeeName;

    /**
     * Property Salary.
     */
    private Integer salary;

    /**
     * Property Department id.
     */
    private Integer departmentId;

    /**
     * Get Employee Id.
     *
     * @return employeeId.
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Set Employee Id.
     *
     * @param employeeId new Id
     */
    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get Employee name.
     *
     * @return employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Set employee name.
     *
     * @param employeeName new Name
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Get employee's salary.
     *
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Set employee's salary.
     *
     * @param salary new salary
     */
    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    /**
     * Get employee's department.
     *
     * @return departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set department id.
     *
     *
     * @param departmentId new department
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", employeeName='" + employeeName + '\''
                + ", salary=" + salary
                + ", departmentId=" + departmentId
                + '}';
    }
}
