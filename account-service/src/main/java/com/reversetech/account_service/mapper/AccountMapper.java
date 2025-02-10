package com.reversetech.account_service.mapper;


import com.reversetech.account_service.dto.AccountDto;
import com.reversetech.account_service.entity.Account;

public interface AccountMapper {

    AccountDto toDto(Account account);
    Account toEntity(AccountDto accountDto);
}
