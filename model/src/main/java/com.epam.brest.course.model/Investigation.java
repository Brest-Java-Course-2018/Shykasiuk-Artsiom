package com.epam.brest.course.model;

import java.util.Date;

/**
 * POJO Investigation
 */
public class Investigation {

    /**
     * Property id
     */
    private Integer investigationId;

    /**
     * Property foreign id
     */
    private Integer detectiveId;

    /**
     * Property name
     */
    private String investigationName;

    /**
     * Property description
     */
    private String description;

    /**
     * Property isSolved
     */
    private Boolean isSolved;

    /**
     * Property date
     */
    private Date dateSolved;

    public Integer getInvestigationId() {
        return investigationId;
    }

    public void setInvestigationId(Integer investigationId) {
        this.investigationId = investigationId;
    }

    public Integer getDetectiveId() {
        return detectiveId;
    }

    public void setDetectiveId(Integer detectiveId) {
        this.detectiveId = detectiveId;
    }

    public String getInvestigationName() {
        return investigationName;
    }

    public void setInvestigationName(String investigationName) {
        this.investigationName = investigationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    public Date getDateSolved() {
        return dateSolved;
    }

    public void setDateSolved(Date dateSolved) {
        if(isSolved)
            this.dateSolved = dateSolved;
    }

    @Override
    public String toString() {
        return "Investigation{" +
                "investigationId=" + investigationId +
                ", detectiveId=" + detectiveId +
                ", investigationName='" + investigationName + '\'' +
                ", description='" + description + '\'' +
                ", isSolved=" + isSolved +
                ", dateSolved=" + dateSolved +
                '}';
    }
}
