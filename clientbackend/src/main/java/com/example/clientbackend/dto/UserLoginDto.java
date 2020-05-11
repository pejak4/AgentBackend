package com.example.clientbackend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {

    private String email;
    private String password;

}
