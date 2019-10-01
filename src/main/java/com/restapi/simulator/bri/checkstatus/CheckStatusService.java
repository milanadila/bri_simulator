package com.restapi.simulator.bri.checkstatus;

import com.restapi.simulator.bri.baseresponse.BaseResponse;
import com.restapi.simulator.bri.baseresponse.CheckStatusBaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CheckStatusService {

    public ResponseEntity<CheckStatusBaseResponse> doCheckStatus(@RequestBody CheckStatusRequest checkStatusRequest) {
        CheckStatusResponse checkStatusResponse = new CheckStatusResponse();
        ResponseEntity<CheckStatusBaseResponse> re;
        if ((checkStatusRequest.getNoReferral() != null && !("".equals(checkStatusRequest.getNoReferral())))) {
            String fourDigits = checkStatusRequest.getNoReferral().substring(checkStatusRequest.getNoReferral().length()-4);

            if (fourDigits.equals("0002")) {
                checkStatusResponse.setResponseCode("0300");
                checkStatusResponse.setResponseDescription("Cek Status sukses");
                checkStatusResponse.setErrorDescription("");
                checkStatusResponse.setNoReferral(checkStatusRequest.getNoReferral());
                checkStatusResponse.setJournalSeq("3289331");
                checkStatusResponse.setInternalTransferStatus("Payment Success");
                checkStatusResponse.setInternalTransferErrorMessage("");
                re = setResponse(HttpStatus.OK, checkStatusResponse);
            } else if (fourDigits.equals("0001")) {
                checkStatusResponse.setResponseCode("0000");
                checkStatusResponse.setResponseDescription("Cek Status gagal");
                checkStatusResponse.setErrorDescription("no referral wrong");
                re = setResponse(HttpStatus.BAD_REQUEST, checkStatusResponse);
            } else {
                checkStatusResponse.setResponseCode("4001");
                checkStatusResponse.setResponseDescription("Cek Status gagal");
                checkStatusResponse.setErrorDescription("Unknown");
                re = setResponse(HttpStatus.INTERNAL_SERVER_ERROR, checkStatusResponse);
            }
            return re;
        } else {
            checkStatusResponse.setResponseCode("4001");
            checkStatusResponse.setResponseDescription("Cek Status gagal");
            checkStatusResponse.setErrorDescription("Unknown");
            re = setResponse(HttpStatus.INTERNAL_SERVER_ERROR, checkStatusResponse);

            return re;
        }
    }

    private static ResponseEntity<CheckStatusBaseResponse> setResponse(HttpStatus httpStatus, CheckStatusResponse checkStatusResponse) {
        BaseResponse<CheckStatusResponse> response = new BaseResponse<>();
        CheckStatusBaseResponse cbs = new CheckStatusBaseResponse();
        response.setData(checkStatusResponse);
        cbs.setDoCheckStatusResponse(response);
        return ResponseEntity.status(httpStatus).body(cbs);
    }
}
