package com.newgen.iforms.user.flexiapi;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FlexiRequestInput {
    @JsonProperty("classIsArray")
    private String classIsArray;

    @JsonProperty("member")
    private List<FlexiRequestMember> member;

    @JsonProperty("className")
    private String className;

    // Getters and setters
    public String getClassIsArray() {
        return classIsArray;
    }

    public void setClassIsArray(String classIsArray) {
        this.classIsArray = classIsArray;
    }

    public List<FlexiRequestMember> getMember() {
        return member;
    }

    public void setMember(List<FlexiRequestMember> member) {
        this.member = member;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
