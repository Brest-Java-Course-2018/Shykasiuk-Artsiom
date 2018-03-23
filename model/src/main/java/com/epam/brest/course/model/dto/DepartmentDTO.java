package com.epam.brest.course.model.dto;

public class DepartmentDTO {

    /**
     * Property Id.
     */
    private Integer departmentId;

    /**
     * Property Name.
     */
    private String departmentName;

    /**
     * Property AVGsalary.
     */
    private String AVGsalary;

    /**
     * Property Id.
     */
    private Integer employeeId;

    /**
     * Get department Id.
     *
     * @return DepartmentId.
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set department Id.
     *
     * @param departmentId new Id.
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Get department Name.
     *
     * @return DepartmentName.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Set department Name.
     *
     * @param departmentName new Name.
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Get department AVGsalary.
     *
     * @return AVGsalary.
     */
    public String getAVGsalary() {
        return AVGsalary;
    }

    /**
     * Set department AVGsalary.
     *
     * @param AVGsalary new Name.
     */
    public void setAVGsalary(final String AVGsalary) {
        this.AVGsalary = AVGsalary;
    }

    /**
     * Get employee Id.
     *
     * @return EmployeeId.
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Set employee Id.
     *
     * @param employeeId new Id.
     */
    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName
                + '\'' + ", AVGsalary='" + AVGsalary
                + '\'' + ", employeeId=" + employeeId
                + '}';
    }
}
