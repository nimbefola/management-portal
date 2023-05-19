package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.dto.*;
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

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Valid UserSignUpRequestDto userSignUpRequestDto) {
        try {
            return new ResponseEntity<>(userManagementServiceClient.signUp(userSignUpRequestDto), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping( produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody @Valid AccountDTO request) {
        try {
            return new ResponseEntity<>(userManagementServiceClient.create(request), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/validate")
    public ResponseEntity<?> validate(@RequestBody @Valid ValidateDto request){
        try{
            return new ResponseEntity<>(userManagementServiceClient.validate(request), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO request) {
        try{
            return new ResponseEntity<>(userManagementServiceClient.login(request), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody @Valid ChangePasswordDTO request,@RequestParam("authentication") String authentication) {
        try{
            return new ResponseEntity<>(userManagementServiceClient.changePassword(request,authentication), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody @Valid ForgotPasswordDTO request) {
        try{
            return new ResponseEntity<>(userManagementServiceClient.forgotPassword(request), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/validateTokenAndPassword")
    public ResponseEntity<?> retrievePassword(@RequestBody @Valid RetrieveForgotPasswordDTO request) {
        try{
            return new ResponseEntity<>(userManagementServiceClient.retrievePassword(request), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(userManagementServiceClient.getById(id), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(@RequestParam("authentication") String authentication){
        try {
            return new ResponseEntity<>(userManagementServiceClient.getAll(authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<?> updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status,@RequestParam("authentication") String authentication) {
        try {
            return new ResponseEntity<>(userManagementServiceClient.updateAccountStatus(id, status, authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "profile/picture/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadProfilePicture(@PathVariable("id") String id, @RequestParam("file") MultipartFile file,@RequestParam("authentication") String authentication) {
        try{
            return new ResponseEntity<>(userManagementServiceClient.uploadProfilePicture(id, file,authentication),HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "service/link", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> linkAccountToService(@RequestBody @Valid AccountServiceLinkDTO accountServiceLinkDTO,@RequestParam("authentication") String authentication){
        try{
            return new ResponseEntity<>(userManagementServiceClient.linkAccountToService(accountServiceLinkDTO,authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "enquiry/{msisdn}", produces = "application/json")
    public ResponseEntity<?> getAccountByMsisdn(@PathVariable("msisdn") String msisdn,@RequestParam("authentication") String authentication){
        try{
            return new ResponseEntity<>(userManagementServiceClient.getAccountByMsisdn(msisdn,authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/transfer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO,@RequestParam("authentication") String authentication){
        try{
            return new ResponseEntity<>(userManagementServiceClient.transfer(transferDTO,authentication), HttpStatus.OK); //,authentication
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/withdraw", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdrawDTO,@RequestParam("authentication") String authentication){
        try {
            return new ResponseEntity<>(userManagementServiceClient.withdraw(withdrawDTO,authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/payment/{beneficiaryId}/{externalTransactionId}", produces = "application/json")
    public ResponseEntity<String> payment(@PathVariable("beneficiaryId") String beneficiaryId, @PathVariable("externalTransactionId") String externalTransactionId,@RequestParam("authentication") String authentication){
        try {
            return new ResponseEntity<>(userManagementServiceClient.payment(beneficiaryId, externalTransactionId,authentication), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



//    @GetMapping(path = "deposit/status/check/{externalTransactionId}", produces = "application/json")
//    public ResponseEntity<PaystackPaymentStatusDTO> getDepositStatus(@PathVariable("externalTransactionId") String externalTransactionId){
//        return new ResponseEntity<>(userManagementServiceClient.getDepositStatus(externalTransactionId), HttpStatus.OK);
//    }

}
