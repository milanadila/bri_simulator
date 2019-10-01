package com.restapi.simulator.bri.payment;

import lombok.Data;

@Data
public class PaymentResponse {

    private String responseCode;
    private String responseDescription;
    private String errorDescription;
    private String journalSeq;
}
