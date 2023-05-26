package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.ApiSuccessResponse;
import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "account")
@CrossOrigin(origins = "*")
public class AccountEndpoint {
    @Autowired
    private UserManagementServiceClient userManagementServiceClient;

    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody @Valid UserSignUpRequestDto userSignUpRequestDto) {

        UserSignUpResponseDto result = userManagementServiceClient.signUp(userSignUpRequestDto);
        return ApiSuccessResponse.generateResponse("User successfully Created",HttpStatus.OK,result);

    }


    @PostMapping(path = "/validate")
    public ResponseEntity<Object> validate(@RequestBody @Valid ValidateDto request) {

        ValidateDto result = userManagementServiceClient.validate(request);
        return ApiSuccessResponse.generateResponse("Successfully Validated",HttpStatus.OK,result);

    }

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDTO request) {

        LoginResponseDto result = userManagementServiceClient.login(request);

        return ApiSuccessResponse.generateResponse("Successful Login",HttpStatus.OK,result);
    }

    @PostMapping(path = "/changePassword")
    public ResponseEntity<Object> changePassword(@RequestBody @Valid ChangePasswordDTO request,@RequestParam("authentication") String authentication)  {

        ChangePasswordDTO result = userManagementServiceClient.changePassword(request,authentication);

        return ApiSuccessResponse.generateResponse("Password Changed Successfully",HttpStatus.OK,result);
    }

    @PostMapping(path = "/forgotPassword")
    public ResponseEntity<Object> forgotPassword(@RequestBody @Valid ForgotPasswordDTO request)  {

        ForgotPasswordDTO result = userManagementServiceClient.forgotPassword(request);

        return  ApiSuccessResponse.generateResponse("Success! Use the token sent to validate and reset password",
                HttpStatus.OK,result);
    }

    @PostMapping(path = "/validateTokenAndPassword")
    public ResponseEntity<Object> retrievePassword(@RequestBody @Valid RetrieveForgotPasswordDTO request) {

        RetrieveForgotPasswordDTO result = userManagementServiceClient.retrievePassword(request);
        return ApiSuccessResponse.generateResponse("User successfully recover access",HttpStatus.OK,result);

    }

    @PostMapping( produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody @Valid AccountDTO request) {

        return new ResponseEntity<>(userManagementServiceClient.create(request), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getById(@PathVariable("id") String id){

            return new ResponseEntity<>(userManagementServiceClient.getById(id), HttpStatus.OK);
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.getAll(authentication), HttpStatus.OK);
    }


    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<?> updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status,@RequestParam("authentication") String authentication) {

            return new ResponseEntity<>(userManagementServiceClient.updateAccountStatus(id, status, authentication), HttpStatus.OK);
    }

    @PostMapping(path = "profile/picture/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadProfilePicture(@PathVariable("id") String id, @RequestParam("file") MultipartFile file,@RequestParam("authentication") String authentication) {
            return new ResponseEntity<>(userManagementServiceClient.uploadProfilePicture(id, file,authentication),HttpStatus.OK);

    }

    @PostMapping(path = "service/link", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> linkAccountToService(@RequestBody @Valid AccountServiceLinkDTO accountServiceLinkDTO,@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.linkAccountToService(accountServiceLinkDTO,authentication), HttpStatus.OK);
    }


    @GetMapping(path = "enquiry/{msisdn}", produces = "application/json")
    public ResponseEntity<?> getAccountByMsisdn(@PathVariable("msisdn") String msisdn,@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.getAccountByMsisdn(msisdn,authentication), HttpStatus.OK);

    }

    @PostMapping(path = "/transfer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO,@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.transfer(transferDTO,authentication), HttpStatus.OK); //,authentication

    }

    @PostMapping(path = "/withdraw", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdrawDTO,@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.withdraw(withdrawDTO,authentication), HttpStatus.OK);

    }

    @PutMapping(path = "/payment/{beneficiaryId}/{externalTransactionId}", produces = "application/json")
    public ResponseEntity<String> payment(@PathVariable("beneficiaryId") String beneficiaryId, @PathVariable("externalTransactionId") String externalTransactionId,@RequestParam("authentication") String authentication){

            return new ResponseEntity<>(userManagementServiceClient.payment(beneficiaryId, externalTransactionId,authentication), HttpStatus.OK);

    }



//    @GetMapping(path = "deposit/status/check/{externalTransactionId}", produces = "application/json")
//    public ResponseEntity<PaystackPaymentStatusDTO> getDepositStatus(@PathVariable("externalTransactionId") String externalTransactionId){
//        return new ResponseEntity<>(userManagementServiceClient.getDepositStatus(externalTransactionId), HttpStatus.OK);
//    }

}
