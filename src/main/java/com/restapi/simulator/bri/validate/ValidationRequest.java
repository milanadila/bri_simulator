package com.restapi.simulator.bri.validate;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class ValidationRequest {

    @NotEmpty(message = "not empty")
    @Length(max = 15, message = "max 15 char")
    private String sourceAccount;

    @NotEmpty(message = "not empty")
    @Length(max = 15, message = "mas 15 char")
    private String beneficiaryAccount;
}
