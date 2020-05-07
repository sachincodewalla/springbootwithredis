package com.app.redis.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.redis.crud.entity.Authentication;
import com.app.redis.crud.service.IRedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private IRedisService redisService;
	
	@PostMapping("/add")
	public void add(@RequestBody Authentication authentication) {
		redisService.add(authentication);
	}

	@DeleteMapping("/delete/{token}")
	public void delete(@PathVariable String token) {
		redisService.delete(token);
	}

	@GetMapping("/get/{token}")
	public Authentication findAuthentication(@PathVariable String token) {
		return redisService.findAuthentication(token);
	}

	@GetMapping("/get/all")
	public Map<String, Authentication> findAll() {
		return redisService.findAll();
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Authentication authentication) {
		redisService.update(authentication);
	}
}
