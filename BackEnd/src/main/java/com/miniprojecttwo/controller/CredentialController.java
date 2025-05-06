package com.miniprojecttwo.controller;

import com.miniprojecttwo.entity.Credential;
import com.miniprojecttwo.entity.Patient;
import com.miniprojecttwo.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credential credential) {
        Credential user = credentialService.login(credential.getUsername(), credential.getPassword());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 BAD_REQUEST
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> signup(@RequestBody Credential credential) {
        Credential isUserExist = credentialService.findByusername(credential.getUsername());
        System.out.println(isUserExist);
        if (isUserExist != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body("User already exist " + credential.getUsername());
        }

        Credential user = credentialService.signup(credential);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.CREATED); // 201 CREATED
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 BAD_REQUEST
        }
    }

}
