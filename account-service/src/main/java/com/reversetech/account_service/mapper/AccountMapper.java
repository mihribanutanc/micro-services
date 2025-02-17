package com.reversetech.account_service.mapper;


import com.reversetech.account_service.entity.Account;
import com.reversetech.dto.AccountDto;

public interface AccountMapper {

    AccountDto toDto(Account account);
    Account toEntity(AccountDto accountDto);
}
