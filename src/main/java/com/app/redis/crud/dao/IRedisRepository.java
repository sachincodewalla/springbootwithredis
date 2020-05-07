package com.app.redis.crud.dao;

import java.util.Map;

import com.app.redis.crud.entity.Authentication;

public interface IRedisRepository {

	void add(Authentication authentication);

//	void add(String token, String userName, Long userId, Integer organizationId);
	
	void delete(String token);

	Authentication findAuthentication(String token);

	Map<String, Authentication> findAll();

	void update(Authentication authentication);

}
