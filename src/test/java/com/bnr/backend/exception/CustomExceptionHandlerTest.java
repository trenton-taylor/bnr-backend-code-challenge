package com.bnr.backend.exception;

import com.bnr.backend.domain.ServiceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ExtendWith(MockitoExtension.class)
public class CustomExceptionHandlerTest extends ResponseEntityExceptionHandler {

    @Mock
    WebRequest webRequest;

    @InjectMocks
    CustomExceptionHandler exceptionHandlerTest;

    @Test
    public void testHandleStockException(){
        ResponseEntity<Object> ro = exceptionHandlerTest.handleStockException(new DiaryServiceException("Exception"), webRequest);
        ServiceResponse response = (ServiceResponse) ro.getBody();
        Assertions.assertEquals(response.getMessage(),"Service Exception: Exception");
    }


}
