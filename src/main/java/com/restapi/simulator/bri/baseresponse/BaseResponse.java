package com.restapi.simulator.bri.baseresponse;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private String message;
    private T Data;
}
