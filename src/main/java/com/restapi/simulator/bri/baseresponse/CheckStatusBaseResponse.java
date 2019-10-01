package com.restapi.simulator.bri.baseresponse;

import com.restapi.simulator.bri.checkstatus.CheckStatusResponse;
import lombok.Data;

@Data
public class CheckStatusBaseResponse {
    BaseResponse<CheckStatusResponse> doCheckStatusResponse;
}
