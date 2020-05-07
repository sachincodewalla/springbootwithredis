package com.app.redis.crud.service;

import java.util.Map;

import com.app.redis.crud.entity.Authentication;

public interface IRedisService {

	void add(Authentication authentication);

	void delete(String token);

	Authentication findAuthentication(String token);

	Map<String, Authentication> findAll();

	void update(Authentication authentication);
}
