package com.bnr.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiaryServiceException  extends RuntimeException{
    public DiaryServiceException(String message){
        super(message);
        log.error(this.toString());
    }
}
