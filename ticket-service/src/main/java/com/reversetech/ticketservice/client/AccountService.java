package com.reversetech.ticketservice.client;

import com.reversetech.ticketservice.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "account-service", url = "http://localhost:9050/account")
public interface AccountService {

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> get(@PathVariable("id") UUID id);
}
