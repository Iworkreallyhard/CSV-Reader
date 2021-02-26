package com.sparta.ben.controller.attributes;

public class Attribute {
    private Integer attributeNumber;
    private String attributeName;

    public Attribute(Integer attributeNumber, String attributeName) {
        this.attributeNumber = attributeNumber;
        this.attributeName = attributeName;
    }

    public Integer getAttributeNumber() {
        return attributeNumber;
    }

    public void setAttributeNumber(Integer attributeNumber) {
        this.attributeNumber = attributeNumber;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
