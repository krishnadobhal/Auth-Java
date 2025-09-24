package org.example.auth.service;

import org.example.auth.helpers.AuthPassengerDetails;
import org.example.auth.models.Passenger;
import org.example.auth.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  PassengerRepository passengerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);
        if (passenger.isPresent())
            return new AuthPassengerDetails(passenger.get());
        else throw new UsernameNotFoundException("User not found with email : " + email);
    }
}
