package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.configs.FeignSupportConfig;
import com.pentspace.managementportal.dto.*;


import com.pentspace.managementportal.model.Account;
import com.pentspace.managementportal.model.Bank;
import com.pentspace.managementportal.model.Service;
import com.pentspace.managementportal.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;
//localhost:30301
//http://3.252.93.217:30301
@FeignClient(value = "UserManagementServiceClient", url = "http://3.252.93.217:30301", configuration = FeignSupportConfig.class)
public interface UserManagementServiceClient {

    @PostMapping(path = "account/signUp", produces = "application/json")
    UserSignUpResponseDto signUp(@RequestBody @Valid UserSignUpRequestDto userSignUpRequestDto);
    @PostMapping(path = "account", produces = "application/json", consumes = "application/json")
    Account create(@RequestBody @Valid AccountDTO request);

    @PostMapping(path = "account/validate", produces = "application/json")
    ValidateDto validate(@RequestBody @Valid ValidateDto validateDto);

    @PostMapping(path = "account/login", produces = "application/json", consumes = "application/json")
    LoginResponseDto login(@RequestBody LoginDTO loginDTO);

    @PostMapping(path = "account/changePassword", produces = "application/json", consumes = "application/json")
    ChangePasswordDTO changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,@RequestParam("authentication") String authentication)  ;

    @PostMapping(path = "account/forgotPassword", produces = "application/json", consumes = "application/json")
    ForgotPasswordDTO forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) ;

    @PostMapping(path = "account/validateTokenAndPassword", produces = "application/json", consumes = "application/json")
    RetrieveForgotPasswordDTO retrievePassword(@RequestBody RetrieveForgotPasswordDTO retrieveForgotPasswordDTO);


    @GetMapping(path = "account/{id}", produces = "application/json")
    Account getById(@PathVariable("id") String id);

    @GetMapping(path ="account", produces = "application/json")
    List<Account> getAll(@RequestParam("authentication") String authentication);

    @PutMapping(path = "account/status/update", produces = "application/json")
    Account updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status,@RequestParam("authentication") String authentication);

    @PostMapping(path = "account/profile/picture/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Account uploadProfilePicture(@PathVariable("id") String id, @RequestPart("file") MultipartFile file,@RequestParam("authentication") String authentication);

    @PostMapping(path = "account/service/link", consumes = "application/json", produces = "application/json")
    Account linkAccountToService(@RequestBody @Valid AccountServiceLinkDTO accountServiceLinkDTO,@RequestParam("authentication") String authentication);

    @GetMapping(path = "account/enquiry/{msisdn}", produces = "application/json")
    Account getAccountByMsisdn(@PathVariable("msisdn") String msisdn,@RequestParam("authentication") String authentication);

    @PostMapping(path = "account/transfer", consumes = "application/json", produces = "application/json")
    String transfer(@RequestBody TransferDTO transferDTO,@RequestParam("authentication") String authentication);

    @PostMapping(path = "account/withdraw",consumes = "application/json", produces = "application/json")
    String withdraw(@RequestBody WithdrawDTO withdrawDTO,@RequestParam("authentication") String authentication);

    @PutMapping(path = "account/payment/{beneficiaryId}/{externalTransactionId}", produces = "application/json")
    String payment(@PathVariable("beneficiaryId") String beneficiaryId, @PathVariable("externalTransactionId") String externalTransactionId,@RequestParam("authentication") String authentication);

    @GetMapping(path = "account/deposit/status/check/{externalTransactionId}", produces = "application/json")
    PaystackPaymentStatusDTO getDepositStatus(@PathVariable("externalTransactionId") String externalTransactionId,@RequestParam("authentication") String authentication);

    @PostMapping(path = "service", produces = "application/json", consumes = "application/json")
    Service create(@RequestBody @Valid ServiceDTO serviceDTO,@RequestParam("authentication") String authentication);

    @GetMapping(path = "service/{id}", produces = "application/json")
    Service getServiceById(@PathVariable("id") String accountId);

    @GetMapping(path = "service", produces = "application/json")
    List<Service> getAllService();

    @GetMapping(path = "bank/{id}", produces = "application/json")
    Bank getBankById(@PathVariable("id") String bankId);

    @GetMapping(path = "bank", produces = "application/json")
    List<Bank> getAllBanks();
}
