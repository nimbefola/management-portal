package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.dto.*;
import com.pentspace.managementportal.model.Account;
import com.pentspace.managementportal.model.Project;
import com.pentspace.managementportal.model.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "CrowdFundingServiceClient", url = "http://localhost:30304/project")
public interface CrowdFundingServiceClient {

    @PostMapping( consumes = "application/json", produces = "application/json")
    Project create(@RequestBody Project project);

    @GetMapping(path = "{projectId}", produces = "application/json")
    Project get(@PathVariable ("projectId") String projectId);

    @GetMapping(produces = "application/json")
    List<Project> getAll();

    @PostMapping(path = "/fund", produces = "application/json")
    String fund(@RequestParam("projectId") String projectId, @RequestParam("accountId") String accountId,@RequestParam("amount") String amount);
    @GetMapping(path = "account/{id}", produces = "application/json")
    List<Project> getByAccountId(@PathVariable ("id") String id);

    @PostMapping(path = "/picture/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Project uploadProjectPicture(@RequestParam("id") String id, @RequestPart("file") MultipartFile file);

    @PutMapping(path = "/status/update", produces = "application/json")
    Project updateProjectStatus(@RequestParam("id") String id, @RequestParam("status") String status);
}
