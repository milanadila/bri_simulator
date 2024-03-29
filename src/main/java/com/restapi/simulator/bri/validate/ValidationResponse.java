package com.restapi.simulator.bri.validate;

import lombok.Data;

@Data
public class ValidationResponse {

    private String responseCode;
    private String responseDescription;
    private String errorDescription;

    private String sourceAccount;
    private String sourceAccountName;
    private String sourceAccountStatus;
    private String sourceAccountBalace;
    private String registrationStatus;
    private String beneficiaryAccount;
    private String beneficiaryAccountName;
    private String beneficiaryAccountStatus;
}
