package com.epam.brest.course.model.dto;

public class ShortDepartmentDTO {

    /**
     * Property Id.
     */
    private Integer departmentId;

    /**
     * Property Name.
     */
    private String departmentName;

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

    @Override
    public String toString() {
        return "ShortDepartmentDTO{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName
                + '\'' + '}';
    }
}
