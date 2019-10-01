package com.restapi.simulator.bri.payment;

import com.restapi.simulator.bri.baseresponse.PaymentBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<PaymentBaseResponse> doPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return paymentService.doPayment(paymentRequest);
    }
}
