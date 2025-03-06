package com.reversetech.account_service.service;


import com.reversetech.account_service.dto.SaveAccountDto;
import com.reversetech.account_service.entity.Account;
import com.reversetech.account_service.mapper.AccountMapper;
import com.reversetech.account_service.repo.AccountRepository;
import com.reversetech.dto.AccountDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;


    public AccountDto get(UUID id) {
        Optional<Account> account = accountRepository.findById(id);
        return accountMapper.toDto(account.get());
    }

    public SaveAccountDto save(AccountDto accountDto) {
        Account account = accountRepository.save(accountMapper.toEntity(accountDto));
        return accountMapper.toSaveAccountDto(account);
    }

    @Transactional
    public AccountDto update(UUID id, AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + id));
        accountMapper.updateAccountFromDto(accountDto, existingAccount);
        return accountMapper.toDto(accountRepository.save(existingAccount));
    }

    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }

    public List<AccountDto> findAll() {
        return accountMapper.toDtoList(accountRepository.findAll());
    }
}
