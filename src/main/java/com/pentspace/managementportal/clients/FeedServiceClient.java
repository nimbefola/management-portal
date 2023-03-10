package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.dto.CommentDto;
import com.pentspace.managementportal.model.Feed;
import com.pentspace.managementportal.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "FeedServiceClient", url = "http://localhost:30303/feed")
public interface FeedServiceClient {

    @PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Feed create(@RequestPart("file") MultipartFile file, @RequestParam("message") String message, @RequestParam("username") String username );

    @GetMapping(path = "/{id}", produces = "application/json")
    Feed getById(@PathVariable("id") String id);

    @GetMapping(produces = "application/json")
    List<Feed> getAll();

    @GetMapping(path = "/account", produces = "application/json")
    List<Feed> getAll(@RequestParam("username") String username);

    @PutMapping(path = "/status/update", produces = "application/json")
    Feed updateFeedStatus(@RequestParam("id") String id, @RequestParam("status") String status);

    @PostMapping(path = "/comment/{feedId}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    Feed comment(@PathVariable("feedId") String feedId, @RequestBody CommentDto commentDto);
}
