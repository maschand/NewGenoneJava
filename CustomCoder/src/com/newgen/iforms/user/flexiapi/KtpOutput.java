package com.newgen.iforms.user.flexiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KtpOutput {
    @JsonProperty("decision")
    private String decision;

    // Getters and setters
    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
}
