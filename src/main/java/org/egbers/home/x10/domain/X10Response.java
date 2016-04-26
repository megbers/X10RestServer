package org.egbers.home.x10.domain;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.ALWAYS;

@JsonSerialize(include = ALWAYS)
public class X10Response {
    private Boolean success;
    private String errorMessage;

    public X10Response() {

    }

    public X10Response(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
