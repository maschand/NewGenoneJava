package com.newgen.iforms.user.flexiapi;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FlexiResponse {
    @JsonProperty("Status")
    private String status;

    @JsonProperty("Output")
    private FlexiResponseOutput output;

    @JsonProperty("rulesExecuted")
    private List<String> rulesExecuted;

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FlexiResponseOutput getOutput() {
        return output;
    }

    public void setOutput(FlexiResponseOutput output) {
        this.output = output;
    }

    public List<String> getRulesExecuted() {
        return rulesExecuted;
    }

    public void setRulesExecuted(List<String> rulesExecuted) {
        this.rulesExecuted = rulesExecuted;
    }
}
