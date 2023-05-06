package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.UserManagementServiceClient;
import com.pentspace.managementportal.dto.ServiceDTO;
import com.pentspace.managementportal.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "service")
@CrossOrigin(origins = "*")
public class ServiceEndpoint {
    @Autowired
    private UserManagementServiceClient userManagementServiceClient;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Service> create(@RequestBody @Valid ServiceDTO serviceDTO,@RequestParam("authentication") String authentication) {
        return new ResponseEntity<>(userManagementServiceClient.create(serviceDTO,authentication), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Service> getById(@PathVariable("id") String accountId){
        return new ResponseEntity<>(userManagementServiceClient.getServiceById(accountId), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Service>> getAll(){
        return new ResponseEntity<>(userManagementServiceClient.getAllService(), HttpStatus.OK);
    }
}
