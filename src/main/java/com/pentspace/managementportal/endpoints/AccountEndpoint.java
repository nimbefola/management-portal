package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.dto.AccountDTO;
import com.pentspace.managementportal.dto.AccountServiceLinkDTO;
import com.pentspace.managementportal.dto.LoginDTO;
import com.pentspace.managementportal.dto.RegistrationCompletionDTO;
import com.pentspace.managementportal.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "account")
public class AccountEndpoint {
    @Autowired
    private UserManagementServiceClient userManagementServiceClient;

    @PostMapping( produces = "application/json", consumes = "application/json")
    public ResponseEntity<Account> create(@RequestBody @Valid AccountDTO request) {
        return new ResponseEntity<>(userManagementServiceClient.create(request), HttpStatus.OK);
    }

    @PostMapping(path = "/complete/registration", produces = "application/json")
    public ResponseEntity<Account> completeRegistration(@RequestBody RegistrationCompletionDTO request){
        return new ResponseEntity<>(userManagementServiceClient.completeRegistration(request), HttpStatus.OK);
    }

    @PostMapping(path = "/auth", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Account> authenticateAccount(@RequestBody LoginDTO loginDTO){
        return new ResponseEntity<>(userManagementServiceClient.authenticateAccount(loginDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Account> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(userManagementServiceClient.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Account>> getAll(){
        return new ResponseEntity<>(userManagementServiceClient.getAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<Account> updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status){
        return new ResponseEntity<>(userManagementServiceClient.updateAccountStatus(id, status), HttpStatus.OK);
    }

    @PostMapping(path = "profile/picture/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> uploadProfilePicture(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(userManagementServiceClient.uploadProfilePicture(id, file),HttpStatus.OK);
    }

    @PostMapping(path = "service/link", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> linkAccountToService(@RequestBody @Valid AccountServiceLinkDTO accountServiceLinkDTO){
        return new ResponseEntity<>(userManagementServiceClient.linkAccountToService(accountServiceLinkDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/transfer", produces = "text/plain")
    public ResponseEntity<String> transfer(@RequestParam("sourceId") String sourceId, @RequestParam("beneficiaryId") String beneficiaryId, @RequestParam("amount") String amount){
        return new ResponseEntity<>(userManagementServiceClient.transfer(sourceId, beneficiaryId, amount), HttpStatus.OK);
    }

    @PutMapping(path = "/withdraw", produces = "text/plain")
    public ResponseEntity<String> withdraw(@RequestParam("beneficiaryId") String beneficiaryId, @RequestParam("amount") String amount){
        return new ResponseEntity<>(userManagementServiceClient.withdraw(beneficiaryId, amount), HttpStatus.OK);
    }

    @PutMapping(path = "/deposit", produces = "text/plain")
    public ResponseEntity<String> deposit(@RequestParam("beneficiaryId") String beneficiaryId, @RequestParam("externalTransactionId") String externalTransactionId){
        // return new ResponseEntity<>(accountHandler.deposit(beneficiaryId, externalTransactionId), HttpStatus.OK);
        return new ResponseEntity<>(" Awaiting Implementation ", HttpStatus.OK);
    }

}
