package com.restapi.simulator.bri.validate;

import com.restapi.simulator.bri.baseresponse.ValidateBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "validate")
public class ValidationController {

    @Autowired
    ValidationService validationService;


    @PostMapping(produces = "application/json")
    public ResponseEntity<ValidateBaseResponse> doValidate(@RequestBody @Valid ValidationRequest validationRequest) {
        log.info("inquiry request: " + validationRequest.toString());
        return validationService.doValidate(validationRequest);
    }

//    @GetMapping
//    ResponseEntity<BaseResponse> findAll() {
//        BaseResponse response = new BaseResponse();
//        response.setMessage("INI ");
//        response.setData(validationService.InitService());
//    }

//    @PostMapping
//    ResponseEntity<BaseResponse> doValidate(@RequestBody @Valid ValidationRequest request) {
//        BaseResponse resp = new BaseResponse();
//        resp.setResponseCode("0100");
//        resp.setResponseDescription("Inquiry Success");
//        resp.setErrorDescription("");
//        resp.setData(validationService.dOValidate(request));
//
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resp);
//    }
}
