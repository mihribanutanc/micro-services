package com.reversetech.account_service.service;


import com.reversetech.account_service.entity.Account;
import com.reversetech.account_service.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account get(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(UUID id, Account account) {
        Assert.isNull(id, "Id cannot be null");
        return accountRepository.save(account);
    }

    public void delete(UUID id) {

    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
