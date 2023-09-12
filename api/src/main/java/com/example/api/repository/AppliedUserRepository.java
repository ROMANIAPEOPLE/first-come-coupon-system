package com.example.api.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppliedUserRepository {
    
    private final RedisTemplate<String, Long> redisTemplate;

    public AppliedUserRepository(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long add(Long userId) {
        return redisTemplate.opsForSet()
                .add("applied_user", Long.valueOf(userId.toString()));
    }
}
