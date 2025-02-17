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

@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    public Account() {
    }

    @PrimaryKey
    @Id
    private UUID id = UUID.randomUUID();

    public Account(UUID id, Boolean active, Date createdAt, String password, Date birthDate, String email, String surname, String name, String username) {
        this.id = id;
        this.active = active;
        this.createdAt = createdAt;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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
