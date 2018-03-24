package com.epam.brest.course.model;


/**
 * POJO Detective
 */
public class Detective {

    /**
     * Property id
     */
    private Integer detectiveId;

    /**
     * Property name
     */
    private String detectiveName;

    /**
     * Property mail
     */
    private String detectiveMail;

    /**
     * Get detective id
     *
     * @return detectiveId
     */
    public Integer getDetectiveId() {
        return detectiveId;
    }

    /**
     *  Set detective id
     *
     * @param detectiveId new id
     */
    public void setDetectiveId(Integer detectiveId) {
        this.detectiveId = detectiveId;
    }

    /**
     * Get detective name
     *
     * @return detectiveName
     */
    public String getDetectiveName() {
        return detectiveName;
    }

    /**
     * Set detective name
     *
     * @param detectiveName new name
     */
    public void setDetectiveName(String detectiveName) {
        this.detectiveName = detectiveName;
    }

    /**
     * Get detective mail
     *
     * @return detectiveMail
     */
    public String getDetectiveMail() {
        return detectiveMail;
    }

    /**
     * Set detective mail
     *
     * @param detectiveMail new mail
     */
    public void setDetectiveMail(String detectiveMail) {
        this.detectiveMail = detectiveMail;
    }

    @Override
    public String toString() {
        return "Detective{" +
                "detectiveId=" + detectiveId +
                ", detectiveName='" + detectiveName + '\'' +
                ", detectiveMail='" + detectiveMail + '\'' +
                '}';
    }
}
