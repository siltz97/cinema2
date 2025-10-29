package com.example.cinema2.service.authority;

import com.example.cinema2.dto.AuthorityDto;
import com.example.cinema2.entity.AuthorityEntity;

public interface AuthorityService {
    AuthorityEntity find(String name);
}
