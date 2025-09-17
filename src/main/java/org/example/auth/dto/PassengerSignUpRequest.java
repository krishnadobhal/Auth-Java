package org.example.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerSignUpRequest {
    private String email;
    private String password;
    private String name;
    private String phone;
}
