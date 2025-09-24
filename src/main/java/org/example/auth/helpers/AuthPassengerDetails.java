package org.example.auth.helpers;

import org.example.auth.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
// Why do we need this class?
// Because spring security works on UserDeta11s polymorphic type for auth

public class AuthPassengerDetails extends Passenger implements UserDetails {

    private  String username;
    private  String password;

    public AuthPassengerDetails(Passenger passenger) {
        this.username=passenger.getName();
        this.password=passenger.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
