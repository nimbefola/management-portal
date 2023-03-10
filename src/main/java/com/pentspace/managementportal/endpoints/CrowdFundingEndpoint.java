package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.CrowdFundingServiceClient;
import com.pentspace.managementportal.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "project")
@CrossOrigin(origins = "*")
public class CrowdFundingEndpoint {
    @Autowired
    private CrowdFundingServiceClient crowdFundingServiceClient;

    @PostMapping( consumes = "application/json", produces = "application/json")
    public ResponseEntity<Project> create(@RequestBody Project project){
        return ResponseEntity.ok(crowdFundingServiceClient.create(project));
    }

    @GetMapping(path = "{projectId}", produces = "application/json")
    public ResponseEntity<Project> get(@PathVariable ("projectId") String projectId){
        return ResponseEntity.ok(crowdFundingServiceClient.get(projectId));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Project>> getAll(){
        return ResponseEntity.ok(crowdFundingServiceClient.getAll());
    }

    @PostMapping(path = "/fund", produces = "application/json")
    public ResponseEntity<String> fund(@RequestParam("projectId") String projectId, @RequestParam("accountId") String accountId,@RequestParam("amount") String amount){
        return ResponseEntity.ok(crowdFundingServiceClient.fund(projectId, accountId, amount));
    }

    @GetMapping(path = "account/{id}", produces = "application/json")
    public ResponseEntity<List<Project>> getByAccountId(@PathVariable ("id") String id){
        return ResponseEntity.ok(crowdFundingServiceClient.getByAccountId(id));
    }

    @PostMapping(path = "/picture/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> uploadProjectPicture(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(crowdFundingServiceClient.uploadProjectPicture(id, file),HttpStatus.OK);
    }

    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<Project> updateProjectStatus(@RequestParam("id") String id, @RequestParam("status") String status) {
        return new ResponseEntity<>(crowdFundingServiceClient.updateProjectStatus(id, status), HttpStatus.OK);
    }

}
