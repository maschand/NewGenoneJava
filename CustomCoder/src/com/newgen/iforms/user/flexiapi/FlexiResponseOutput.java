package com.newgen.iforms.user.flexiapi;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlexiResponseOutput {
    @JsonProperty("ktp_output")
    private KtpOutput ktpOutput;

    @JsonProperty("ktp_input")
    private KtpInput ktpInput;

    // Getters and setters
    public KtpOutput getKtpOutput() {
        return ktpOutput;
    }

    public void setKtpOutput(KtpOutput ktpOutput) {
        this.ktpOutput = ktpOutput;
    }

    public KtpInput getKtpInput() {
        return ktpInput;
    }

    public void setKtpInput(KtpInput ktpInput) {
        this.ktpInput = ktpInput;
    }
}
