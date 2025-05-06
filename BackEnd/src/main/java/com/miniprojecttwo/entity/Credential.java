package com.miniprojecttwo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "creditdb")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "username")
    @JsonProperty("username")
    @NotBlank
    @Size(min = 3, max = 10)
    private String username;

    @Column(name = "password")
    @JsonProperty("password")
    @NotBlank
    private String password;

    @Column(name = "user_role")
    @JsonProperty("user_role")
    @NotBlank
    private String user_role;
}
