package com.newgen.iforms.user.flexiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlexiRequestOutput {
    @JsonProperty("classIsArray")
    private String classIsArray;

    @JsonProperty("member")
    private FlexiRequestMember member;

    @JsonProperty("className")
    private String className;

    // Getters and setters
    public String getClassIsArray() {
        return classIsArray;
    }

    public void setClassIsArray(String classIsArray) {
        this.classIsArray = classIsArray;
    }

    public FlexiRequestMember getMember() {
        return member;
    }

    public void setMember(FlexiRequestMember member) {
        this.member = member;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
