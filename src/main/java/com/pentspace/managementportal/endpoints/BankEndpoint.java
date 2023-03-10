package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bank")
@CrossOrigin(origins = "*")
public class BankEndpoint {
    @Autowired
    private UserManagementServiceClient userManagementServiceClient;

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Bank> getById(@PathVariable("id") String bankId){
        return new ResponseEntity<>(userManagementServiceClient.getBankById(bankId), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Bank>> getAll(){
        return new ResponseEntity<>(userManagementServiceClient.getAllBanks(), HttpStatus.OK);
    }
}
