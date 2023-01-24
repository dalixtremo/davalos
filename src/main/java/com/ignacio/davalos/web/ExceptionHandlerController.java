package com.ignacio.davalos.web;

import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);
//    @Bean
//    public ErrorAttributes errorAttributes() {
//        // Hide exception field in the return object
//        return new DefaultErrorAttributes() {
//            public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
//                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
//                errorAttributes.remove("exception");
//                return errorAttributes;
//            }
//        };
//    }


    @ExceptionHandler(HttpServerErrorException.class)
    public void handleHttpServerErrorException(HttpServerErrorException ex, HttpServletResponse res) throws IOException {
        res.sendError(ex.getStatusCode().value(),ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletResponse res) throws IOException {
        LOGGER.error("Handled Internal Error Exception", ex);
        res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");
    }

}

