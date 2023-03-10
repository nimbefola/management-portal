package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.dto.*;
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
@CrossOrigin(origins = "*")
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

    @GetMapping(path = "enquiry/{msisdn}", produces = "application/json")
    public ResponseEntity<Account> getAccountByMsisdn(@PathVariable("msisdn") String msisdn){
        return new ResponseEntity<>(userManagementServiceClient.getAccountByMsisdn(msisdn), HttpStatus.OK);
    }

    @PostMapping(path = "/transfer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO){
        return new ResponseEntity<>(userManagementServiceClient.transfer(transferDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/withdraw",consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawDTO withdrawDTO){
        return new ResponseEntity<>(userManagementServiceClient.withdraw(withdrawDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/payment", produces = "text/plain")
    public ResponseEntity<String> payment(@RequestParam("beneficiaryId") String beneficiaryId, @RequestParam("externalTransactionId") String externalTransactionId){
         return new ResponseEntity<>(userManagementServiceClient.payment(beneficiaryId, externalTransactionId), HttpStatus.OK);
    }

    @GetMapping(path = "deposit/status/check/{externalTransactionId}", produces = "application/json")
    public ResponseEntity<PaystackPaymentStatusDTO> getDepositStatus(@PathVariable("externalTransactionId") String externalTransactionId){
        return new ResponseEntity<>(userManagementServiceClient.getDepositStatus(externalTransactionId), HttpStatus.OK);
    }

}
