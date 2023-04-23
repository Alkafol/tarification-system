package com.alkafol.brtmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewClientDto {
    private long phoneNumber;
    private String tariffId;
    private double balance;
}