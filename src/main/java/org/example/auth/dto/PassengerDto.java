package org.example.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private Date CreatedAt;
}
