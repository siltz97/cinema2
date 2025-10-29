package com.example.cinema2.service.authority;

import com.example.cinema2.entity.AuthorityEntity;
import com.example.cinema2.repo.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl  implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public AuthorityEntity find(String name){
        return authorityRepository.findByAuthName(name).get();
    }
}
