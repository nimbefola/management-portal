package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.TransactionServiceClient;
import com.pentspace.managementportal.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "transaction")
@CrossOrigin(origins = "*")
public class TransactionEndpoint {
    @Autowired
    private TransactionServiceClient transactionServiceClient;

    @PostMapping( consumes = "application/json", produces = "application/json")
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionServiceClient.create(transaction));
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Transaction> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(transactionServiceClient.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Transaction>> getAll(){
        return new ResponseEntity<>(transactionServiceClient.getAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<Transaction> updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status){
        return new ResponseEntity<>(transactionServiceClient.updateAccountStatus(id, status), HttpStatus.OK);
    }

    @PutMapping(path = "/deposit/status", produces = "application/json")
    public ResponseEntity<String> getDepositStatus(@RequestParam("id") String id, @RequestParam("otp") String otp){
        return new ResponseEntity<>(transactionServiceClient.getDepositStatus(id, otp), HttpStatus.OK);
    }

}
