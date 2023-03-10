package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.dto.CommentDto;
import com.pentspace.managementportal.model.Feed;
import com.pentspace.managementportal.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "TransactionServiceClient", url = "http://localhost:30305/transaction")
public interface TransactionServiceClient {
    @PostMapping(consumes = "application/json", produces = "application/json")
    Transaction create(@RequestBody Transaction transaction);

    @GetMapping(path = "/{id}", produces = "application/json")
    Transaction getById(@PathVariable("id") String id);

    @GetMapping(produces = "application/json")
    List<Transaction> getAll();

    @PutMapping(path = "/status/update", produces = "application/json")
    Transaction updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status);

    @PutMapping(path = "/deposit/status", produces = "application/json")
    String getDepositStatus(@RequestParam("id") String id, @RequestParam("otp") String otp);

}
