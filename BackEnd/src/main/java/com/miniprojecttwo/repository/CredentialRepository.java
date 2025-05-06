package com.miniprojecttwo.repository;

import com.miniprojecttwo.entity.Credential;
import com.miniprojecttwo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Credential findByusername(String username);

}
