package com.restapi.simulator.bri.baseresponse;

import com.restapi.simulator.bri.validate.ValidationResponse;
import lombok.Data;

@Data
public class ValidateBaseResponse {
    BaseResponse<ValidationResponse> getValidateResponse;
}
