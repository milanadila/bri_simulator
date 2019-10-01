package com.restapi.simulator.bri.payment;

import com.restapi.simulator.bri.baseresponse.BaseResponse;
import com.restapi.simulator.bri.baseresponse.PaymentBaseResponse;
import com.restapi.simulator.bri.validate.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@Service
public class PaymentService {

    @Autowired
    ValidationService validationService;

    public ResponseEntity<PaymentBaseResponse> doPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = new PaymentResponse();
        ResponseEntity<PaymentBaseResponse> re;

        paymentResponse.setResponseCode("0200");
        paymentResponse.setResponseDescription("Payment Success");
        paymentResponse.setErrorDescription("");
        paymentResponse.setJournalSeq("3289331");
        re = setResponse(HttpStatus.OK, paymentResponse);

        return re;

    }

    private static ResponseEntity<PaymentBaseResponse> setResponse(HttpStatus httpStatus, PaymentResponse paymentResponse) {
        BaseResponse<PaymentResponse> response = new BaseResponse<>();
        PaymentBaseResponse pbs = new PaymentBaseResponse();
        response.setData(paymentResponse);
        pbs.setDoPaymentResponse(response);
        return ResponseEntity.status(httpStatus).body(pbs);
    }
}
