package com.reversetech.account_service.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @Id
    private UUID id = UUID.randomUUID();

    @Column("username")
    private String username;

    
    @Column("name")
    private String name;

    
    @Column("surname")
    private String surname;

    
    @Column("email")
    private String email;

    
    @Column("birth_date")
    private Date birthDate;

    
    @Column("pwd")
    private String password;

    @Column("created_at")
    @CreatedDate
    private Date createdAt;

    @Column("is_active")
    private Boolean active;

}
