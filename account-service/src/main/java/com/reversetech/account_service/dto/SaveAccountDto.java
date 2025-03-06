package com.reversetech.account_service.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class SaveAccountDto {

    private UUID id;

    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;
}
