package com.pentspace.managementportal.exceptions;

public class FeignClientException extends RuntimeException{

    public FeignClientException() {
        super();
    }

    public FeignClientException(String message) {
        super(message);
    }

    public FeignClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
