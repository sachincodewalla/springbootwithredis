package com.app.redis.crud.dao.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.app.redis.crud.dao.IRedisRepository;
import com.app.redis.crud.entity.Authentication;

@Repository
public class RedisRepositoryImpl implements IRedisRepository{

	private static final String KEY = "Token";

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, String, Authentication> hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override
    public void add(Authentication authentication) {
       hashOperations.put(KEY, authentication.getToken(), authentication);
    }
    
    @Override
    public void delete(final String token) {
        hashOperations.delete(KEY, token);
    }
    
    @Override
    public Authentication findAuthentication(final String token){
        return hashOperations.get(KEY, token);
    }
    
    @Override
    public Map<String, Authentication> findAll(){
        return hashOperations.entries(KEY);
    }

	@Override
	public void update(Authentication authentication) {
		hashOperations.put(KEY, authentication.getToken(), authentication);
	}

}
