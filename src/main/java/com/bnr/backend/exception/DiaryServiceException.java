package com.bnr.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiaryServiceException  extends RuntimeException{
    public DiaryServiceException(String message){
        super(message);
    }
}
