package org.example.auth.controller;

import org.example.auth.dto.PassengerSignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/signup/passenger")
    public ResponseEntity<?> signupPassenger(@RequestBody PassengerSignUpRequest request) {
        return null;
    }
}
