package com.reversetech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id ;

    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;
}
