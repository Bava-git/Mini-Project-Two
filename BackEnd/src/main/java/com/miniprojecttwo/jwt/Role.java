package com.miniprojecttwo.jwt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
