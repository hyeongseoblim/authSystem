package com.authsystem.loopy.login.domain.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setKey(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
