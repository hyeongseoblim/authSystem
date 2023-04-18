package com.authsystem.loopy.login.domain.login.service;

public interface RedisService {
    void setKey(String key, Object value);
    Object getKey(String key);
}
