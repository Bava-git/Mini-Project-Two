//package com.miniprojecttwo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CredentialService {
//
//    @Autowired
//    private CredentialRepository credentialRepository;
//
//    public Credential findByusername(String username) {
//        return credentialRepository.findByusername(username);
//    }
//
//    public Credential login(String username, String password) {
//        Credential userExist = credentialRepository.findByusername(username);
//
//        if (userExist != null) {
//            if (userExist.getPassword().equals(password)) {
//                return userExist;
//            }
//        }
//
//        return null;
//    }
//
//    public Credential signup(Credential credential) {
//        return credentialRepository.save(credential);
//    }
//
//
//}
