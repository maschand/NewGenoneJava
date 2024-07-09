package com.newgen.iforms.user.flexiapi;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlexiRequestMember {
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private int type;

    @JsonProperty("value")
    private String value;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
