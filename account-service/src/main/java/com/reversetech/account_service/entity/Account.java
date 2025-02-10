package com.reversetech.account_service.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    @Id
    private UUID id = UUID.randomUUID();

    @Setter
    @Column("username")
    private String username;

    @Setter
    @Column("name")
    private String name;

    @Setter
    @Column("surname")
    private String surname;

    @Setter
    @Column("email")
    private String email;

    @Setter
    @Column("birth_date")
    private Date birthDate;

    @Setter
    @Column("pwd")
    private String password;

    @Column("created_at")
    @CreatedDate
    private Date createdAt;

    @Column("is_active")
    private Boolean active;

}
