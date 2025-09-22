package org.example.auth.dto;

import lombok.*;
import org.example.auth.models.Passenger;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDto {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private Date CreatedAt;
    public static PassengerDto from(Passenger passenger){
        return PassengerDto.builder()
                .id(passenger.getId())
                .email(passenger.getEmail())
                .name(passenger.getName())
                .phone(passenger.getPhone())
                .password(passenger.getPassword())
                .build();
    }
}
