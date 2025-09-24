package org.example.auth.controller;

import org.example.auth.dto.AuthPassengerDto;
import org.example.auth.dto.PassengerDto;
import org.example.auth.dto.PassengerSignUpRequest;
import org.example.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequest passengerSignupRequestDto) {
        PassengerDto response = authService.signupPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/signin/passenger")
    public ResponseEntity<?> signIn(@RequestBody AuthPassengerDto authPassengerDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authPassengerDto.getEmail() ,authPassengerDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>(authPassengerDto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not successfull", HttpStatus.UNAUTHORIZED);
        }
    }

}
