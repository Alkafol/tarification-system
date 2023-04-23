package com.alkafol.srmmicroservice.dto.clientdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegistrationDto {
    private long phoneNumber;
    private String password;
}