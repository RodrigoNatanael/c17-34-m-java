package com.c174.models.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne
    private ProfileEntity profile;


}
