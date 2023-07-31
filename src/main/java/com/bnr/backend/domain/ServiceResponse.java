package com.bnr.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResponse {

    public Integer status;
    public String message;

}
