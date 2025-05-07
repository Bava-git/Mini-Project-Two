//package com.miniprojecttwo.config;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.miniprojecttwo.entity.Role;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//@Table(name = "creditdb")
//public class Credential {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long Id;
//
//    @Column(name = "username")
//    @JsonProperty("username")
//    @NotBlank
//    @Size(min = 3, max = 10)
//    private String username;
//
//    @Column(name = "password")
//    @JsonProperty("password")
//    @NotBlank
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Role> roles = new HashSet<>();
//}
