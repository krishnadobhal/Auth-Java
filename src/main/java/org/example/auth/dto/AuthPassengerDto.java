package org.example.auth.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthPassengerDto {
    public String email;
    public String password;
}
