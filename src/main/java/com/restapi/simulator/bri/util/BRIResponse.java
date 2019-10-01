package com.restapi.simulator.bri.util;

import lombok.Data;

@Data
public class BRIResponse {

    private String responseCode;
    private String responseDescription;
    private String errorDescription;
    private String Data;
}
