package org.example.auth.controller;

import org.example.auth.dto.AuthPassengerDto;
import org.example.auth.dto.PassengerDto;
import org.example.auth.dto.PassengerSignUpRequest;
import org.example.auth.service.AuthService;
import org.example.auth.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequest passengerSignupRequestDto) {
        System.out.println("test"+passengerSignupRequestDto.getName());
        PassengerDto response = authService.signupPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin/passenger")
    public ResponseEntity<?> signIn(@RequestBody AuthPassengerDto authPassengerDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authPassengerDto.getEmail() ,authPassengerDto.getPassword()));
        if (authentication.isAuthenticated()) {
            Map<String,Object>payload=new HashMap<>();
            payload.put("email",authPassengerDto.getEmail());
            String JWTToken= jwtService.createToken(payload,authPassengerDto.getEmail());
            return new ResponseEntity<>(authPassengerDto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not successfull", HttpStatus.UNAUTHORIZED);
        }
    }

}
