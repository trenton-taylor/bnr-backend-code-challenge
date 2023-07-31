package com.bnr.backend.exception;

import com.bnr.backend.domain.ServiceResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Replace the white label error page with a custom response body in case application fails to catch exception.
 */
@RestController
public class ErrorHandler implements ErrorController {

    @ResponseBody
    @RequestMapping("error")
    public ServiceResponse handleRuntimeException(HttpServletRequest request) {

        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String exception;
        if (statusCode == 404) {
            exception = "Route not found.";
        } else if (statusCode == 500) {
            exception = "Internal Server Error.";
        } else {
            exception = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        }

        ServiceResponse response = new ServiceResponse(statusCode, "Service Exception: " + exception);

        return response;
    }


}
