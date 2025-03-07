package com.reversetech.account_service.controller;

import com.reversetech.account_service.api.AccountApi;
import com.reversetech.account_service.dto.AccountDto;
import com.reversetech.account_service.dto.SaveAccountDto;
import com.reversetech.account_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService accountService;

    public ResponseEntity<AccountDto> get(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    public ResponseEntity<SaveAccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    public ResponseEntity<AccountDto> update(@PathVariable("id") UUID id, @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.update(id, accountDto));
    }

    public void delete(UUID id) {
        accountService.delete(id);
    }

    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }
}
