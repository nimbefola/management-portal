package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.configs.FeignSupportConfig;
import com.pentspace.managementportal.dto.*;
import com.pentspace.managementportal.model.Account;
import com.pentspace.managementportal.model.Bank;
import com.pentspace.managementportal.model.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "UserManagementServiceClient", url = "http://localhost:30301/", configuration = FeignSupportConfig.class)
public interface UserManagementServiceClient {

    @PostMapping(path = "account", produces = "application/json", consumes = "application/json")
    Account create(@RequestBody @Valid AccountDTO request);

    @PostMapping(path = "account/complete/registration", produces = "application/json")
    Account completeRegistration(@RequestBody RegistrationCompletionDTO request);

    @PostMapping(path = "account/auth", produces = "application/json", consumes = "application/json")
    Account authenticateAccount(@RequestBody LoginDTO loginDTO);

    @GetMapping(path = "account/{id}", produces = "application/json")
    Account getById(@PathVariable("id") String id);

    @GetMapping(path ="account", produces = "application/json")
    List<Account> getAll();

    @PutMapping(path = "account/status/update", produces = "application/json")
    Account updateAccountStatus(@RequestParam("id") String id, @RequestParam("status") String status);

    @PostMapping(path = "account/profile/picture/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Account uploadProfilePicture(@PathVariable("id") String id, @RequestPart("file") MultipartFile file);

    @PostMapping(path = "account/service/link", consumes = "application/json", produces = "application/json")
    Account linkAccountToService(@RequestBody @Valid AccountServiceLinkDTO accountServiceLinkDTO);

    @GetMapping(path = "account/enquiry/{msisdn}", produces = "application/json")
    Account getAccountByMsisdn(@PathVariable("msisdn") String msisdn);

    @PostMapping(path = "account/transfer", consumes = "application/json", produces = "application/json")
    String transfer(@RequestBody TransferDTO transferDTO);

    @PostMapping(path = "account/withdraw",consumes = "application/json", produces = "application/json")
    String withdraw(@RequestBody WithdrawDTO withdrawDTO);

    @PutMapping(path = "account/payment/{beneficiaryId}/{externalTransactionId}", produces = "application/json")
    String payment(@PathVariable("beneficiaryId") String beneficiaryId, @PathVariable("externalTransactionId") String externalTransactionId);

    @GetMapping(path = "account/deposit/status/check/{externalTransactionId}", produces = "application/json")
    PaystackPaymentStatusDTO getDepositStatus(@PathVariable("externalTransactionId") String externalTransactionId);

    @PostMapping(path = "service", produces = "application/json", consumes = "application/json")
    Service create(@RequestBody @Valid ServiceDTO serviceDTO);

    @GetMapping(path = "service/{id}", produces = "application/json")
    Service getServiceById(@PathVariable("id") String accountId);

    @GetMapping(path = "service", produces = "application/json")
    List<Service> getAllService();

    @GetMapping(path = "bank/{id}", produces = "application/json")
    Bank getBankById(@PathVariable("id") String bankId);

    @GetMapping(path = "bank", produces = "application/json")
    List<Bank> getAllBanks();
}
