package com.app.redis.crud.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.redis.crud.dao.IRedisRepository;
import com.app.redis.crud.entity.Authentication;
import com.app.redis.crud.service.IRedisService;

@Service
public class RedisServiceImpl implements IRedisService{

	@Autowired
	private IRedisRepository redisRepository;
	
	@Override
	public void add(Authentication authentication) {
		redisRepository.add(authentication);
	}
	
	@Override
	public void delete(String token) {
		redisRepository.delete(token);
	}

	@Override
	public Authentication findAuthentication(String token) {
		return redisRepository.findAuthentication(token);
	}

	@Override
	public Map<String, Authentication> findAll() {
		return redisRepository.findAll();
	}

	@Override
	public void update(Authentication authentication) {
		redisRepository.update(authentication);
	}

}
