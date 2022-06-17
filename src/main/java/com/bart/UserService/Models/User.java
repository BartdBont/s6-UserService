package com.bart.UserService.Models;

import com.bart.UserService.DateTimeConfiguration;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;
    private String email;
    private String password;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public User() {
    }

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = DateTimeConfiguration.getCurrentDateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = DateTimeConfiguration.getCurrentDateTime();
    }
}
