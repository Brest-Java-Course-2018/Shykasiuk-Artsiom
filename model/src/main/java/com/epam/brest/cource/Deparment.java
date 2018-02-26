package com.epam.brest.cource;

public class Deparment {

    private Integer departmentId;

    private String departmenName;

    private String description;

    @Override
    public String toString() {
        return "Deparment{" +
                "departmentId=" + departmentId +
                ", departmenName='" + departmenName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
