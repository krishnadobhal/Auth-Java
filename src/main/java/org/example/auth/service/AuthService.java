package org.example.auth.service;

import org.example.auth.dto.PassengerDto;
import org.example.auth.dto.PassengerSignUpRequest;
import org.example.auth.models.Passenger;
import org.example.auth.repository.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignUpRequest passengerSignupRequestDto) {
        Passenger passenger = Passenger.builder()
                .email(passengerSignupRequestDto.getEmail())
                .name(passengerSignupRequestDto.getName())
                .password(bCryptPasswordEncoder.encode(passengerSignupRequestDto.getPassword()))
                .phone(passengerSignupRequestDto.getPhone())
                .build();

        Passenger newPassenger = passengerRepository.save(passenger);

        return PassengerDto.from(newPassenger);
    }
}
