package com.reversetech.client;

import com.reversetech.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @RequestMapping("/account/{id}")
    ResponseEntity<AccountDto> get(@PathVariable("id") UUID id);
}
