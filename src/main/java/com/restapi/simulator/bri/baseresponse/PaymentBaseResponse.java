package com.restapi.simulator.bri.baseresponse;

import com.restapi.simulator.bri.payment.PaymentResponse;
import lombok.Data;

@Data
public class PaymentBaseResponse {
    BaseResponse<PaymentResponse> doPaymentResponse;
}
