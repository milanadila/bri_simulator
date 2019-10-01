package com.restapi.simulator.bri.checkstatus;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class CheckStatusRequest {

    @NotEmpty(message = "not empty")
    @Length(max = 20, message = "max 20 char")
    private String noReferral;
}
