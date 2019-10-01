package com.restapi.simulator.bri.validate;


import com.restapi.simulator.bri.baseresponse.BaseResponse;
import com.restapi.simulator.bri.baseresponse.ValidateBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class ValidationService {

    public ResponseEntity<ValidateBaseResponse> doValidate(@RequestBody ValidationRequest validationRequest) {
        ValidationResponse validationResponse = new ValidationResponse();
        ResponseEntity<ValidateBaseResponse> re;
        if ((validationRequest.getSourceAccount() != null && !("".equals(validationRequest.getSourceAccount())))) {
            String fourDigits = validationRequest.getBeneficiaryAccount().substring(validationRequest.getBeneficiaryAccount().length()-4);
            String threeDigits = validationRequest.getBeneficiaryAccount().substring(validationRequest.getBeneficiaryAccount().length()-3);

            if (fourDigits.equals("7508")) {
                validationResponse.setResponseCode("0100");
                validationResponse.setResponseDescription("Inquiry Success");
                validationResponse.setErrorDescription("");
                validationResponse.setSourceAccount(validationRequest.getSourceAccount());
                validationResponse.setSourceAccountName("BRIAPI SANDBOX");
                validationResponse.setSourceAccountStatus("Rekening Aktif");
                validationResponse.setSourceAccountBalace("258544125122.98");
                validationResponse.setRegistrationStatus("Rekening terdaftar an. bri");
                validationResponse.setBeneficiaryAccount(validationRequest.getBeneficiaryAccount());
                validationResponse.setBeneficiaryAccountName("BRIAPI SANDBOX 2");
                validationResponse.setBeneficiaryAccountStatus("Rekening Aktif");
                re = setResponse(HttpStatus.OK, validationResponse);
            } else if (fourDigits.equals("0011")) {
                validationResponse.setResponseCode("0100");
                validationResponse.setResponseDescription("Inquiry Success");
                validationResponse.setErrorDescription("");
                validationResponse.setSourceAccount(validationRequest.getSourceAccount());
                validationResponse.setSourceAccountStatus("Rekening Aktif");
                validationResponse.setSourceAccountBalace("258544125122.98");
                validationResponse.setRegistrationStatus("Rekening terdaftar an. bri");
                validationResponse.setBeneficiaryAccount(validationRequest.getBeneficiaryAccount());
                validationResponse.setBeneficiaryAccountName("BRIAPI SANDBOX 2");
                validationResponse.setBeneficiaryAccountStatus("Rekening Aktif");
                re = setResponse(HttpStatus.OK, validationResponse);
            } else {
                if (threeDigits.equals("123")) {
                    validationResponse.setResponseCode("4001");
                    validationResponse.setResponseDescription("Inquiry Failed");
                    validationResponse.setErrorDescription("beneficiary account wrong");
                    re = setResponse(HttpStatus.BAD_REQUEST, validationResponse);
                } else if (threeDigits.equals("678")) {
                    validationResponse.setResponseCode("4002");
                    validationResponse.setResponseDescription("Inquiry Failed");
                    validationResponse.setErrorDescription("Process has timed out");
                    re = setResponse(HttpStatus.INTERNAL_SERVER_ERROR, validationResponse);
                } else if (threeDigits.equals("108")) {
                    validationResponse.setResponseCode("4003");
                    validationResponse.setResponseDescription("Inquiry Failed");
                    validationResponse.setErrorDescription("No such account");
                    re = setResponse(HttpStatus.OK, validationResponse);
                } else {
                    validationResponse.setResponseCode("4001");
                    validationResponse.setResponseDescription("Inquiry Failed");
                    validationResponse.setErrorDescription("Unknown");
                    re = setResponse(HttpStatus.INTERNAL_SERVER_ERROR, validationResponse);
                }
            }
            return re;
        } else {
            validationResponse.setResponseCode("4001");
            validationResponse.setResponseDescription("Inquiry Failed");
            validationResponse.setErrorDescription("Unknown");
            re = setResponse(HttpStatus.INTERNAL_SERVER_ERROR, validationResponse);
            return re;
        }


    }

    private static ResponseEntity<ValidateBaseResponse> setResponse(HttpStatus httpStatus, ValidationResponse validationResponse) {
        BaseResponse<ValidationResponse> response = new BaseResponse<>();
        ValidateBaseResponse vbs = new ValidateBaseResponse();
        response.setData(validationResponse);
        vbs.setGetValidateResponse(response);
        log.info("parameter: " + response.getData().toString());
        return ResponseEntity.status(httpStatus).body(vbs);
    }
}











//    @Value("${bri.sourceAccount}")
//    private String sourceAccount;
//
//    @Value("${bri.beneficiaryAccount}")
//    private String beneficiaryAccount;

//    public String InitService(@Value("${sbpg.init.welcome-message:Hello world}") String message) {
//        log.info("INI : " + message); // prints: null
////        log.info("INI : " + sourceAccount);
////        log.info("INI : " + beneficiaryAccount);
//        return message;
//    }


//    public BaseResponse<BRIResponse<ValidationResponse>> doInquiry(ValidationRequest request) {
//
//    }

//    public ValidationResponse dOValidate(ValidationRequest request) {
//        ValidationResponse response = new ValidationResponse();
//        response.setSourceAccount(request.getSourceAccount());
//        request.setBeneficiaryAccount(response.getBeneficiaryAccount());
//        response.setSourceAccount("888801000003301");
//        response.setSourceAccountName("BRIAPI SANDBOX");
//        response.setSourceAccountStatus("Rekening Aktif");
//        response.setSourceAccountBalace("258544125122.98");
//        response.setRegistrationStatus("Rekening terdaftar an. bri");
//        response.setBeneficiaryAccount("888801000157508");
//        response.setBeneficiaryAccountName("BRIAPI SANDBOX 2");
//        response.setBeneficiaryAccountStatus("Rekening Aktif");
//
//        return response;
//    }


