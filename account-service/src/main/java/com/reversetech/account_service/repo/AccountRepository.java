package com.reversetech.account_service.repo;


import com.reversetech.account_service.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends CassandraRepository<Account, UUID> {
}
