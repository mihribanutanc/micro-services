package com.reversetech.account_service.mapper;


import com.reversetech.account_service.dto.SaveAccountDto;
import com.reversetech.account_service.entity.Account;
import com.reversetech.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);
    SaveAccountDto toSaveAccountDto(Account account);
    Account toEntity(AccountDto accountDto);
    List<AccountDto> toDtoList(List<Account> accounts);

    void updateAccountFromDto(AccountDto dto, @MappingTarget Account entity);


}
