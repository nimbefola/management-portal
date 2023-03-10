package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.FeedServiceClient;
import com.pentspace.managementportal.dto.CommentDto;
import com.pentspace.managementportal.model.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "feed")
@CrossOrigin(origins = "*")
public class FeedEndpoint {
    @Autowired
    private FeedServiceClient feedServiceClient;

    @PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Feed> create(@RequestParam("file") MultipartFile file, @RequestParam("message") String message, @RequestParam("username") String username ) {
        return new ResponseEntity<>(feedServiceClient.create(file, username, message), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Feed> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(feedServiceClient.getById(id), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Feed>> getAll(){
        return new ResponseEntity<>(feedServiceClient.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/account", produces = "application/json")
    public ResponseEntity<List<Feed>> getAll(@RequestParam("username") String username){
        return new ResponseEntity<>(feedServiceClient.getAll(username), HttpStatus.OK);
    }

    @PutMapping(path = "/status/update", produces = "application/json")
    public ResponseEntity<Feed> updateFeedStatus(@RequestParam("id") String id, @RequestParam("status") String status) {
        return new ResponseEntity<>(feedServiceClient.updateFeedStatus(id, status), HttpStatus.OK);
    }
    @PostMapping(path = "/comment/{feedId}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Feed> comment(@PathVariable("feedId") String feedId, @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(feedServiceClient.comment(feedId, commentDto), HttpStatus.OK);
    }

}
