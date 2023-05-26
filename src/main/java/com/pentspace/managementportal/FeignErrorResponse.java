package com.pentspace.managementportal;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class FeignErrorResponse {

    public int statusCode;

    public String errorMessage;

}
