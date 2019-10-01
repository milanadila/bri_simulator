package com.restapi.simulator.bri.checkstatus;

import com.restapi.simulator.bri.baseresponse.CheckStatusBaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "checkstatus")
public class CheckStatusController {

    @Autowired
    CheckStatusService checkStatusService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<CheckStatusBaseResponse> doCheckStatus(@RequestBody @Valid CheckStatusRequest checkStatusRequest) {
        return checkStatusService.doCheckStatus(checkStatusRequest);
    }
}
