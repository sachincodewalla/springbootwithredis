package com.app.redis.crud;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.redis.crud.entity.Authentication;
import com.app.redis.crud.service.IRedisService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	public ApplicationTests(){
		
	}
	@Autowired
	private IRedisService redisService;
	
	@Test
	public void addValue() {
		Authentication authentication = new Authentication();
		authentication.setOrganizationId(1);
		authentication.setToken("efgw=hidj-klmm-nolp");
		authentication.setUserId(2L);
		authentication.setUserName("Vipin");
		redisService.add(authentication);
		assertEquals("Vipin", redisService.findAuthentication("efgw=hidj-klmm-nolp").getUserName());
	}
	
	@Test
	public void update() {
		Authentication authentication = new Authentication();
		authentication.setOrganizationId(1);
		authentication.setToken("efgw=hidj-klmm-nolp");
		authentication.setUserId(2L);
		authentication.setUserName("vipin123");
		redisService.update(authentication);
		assertEquals("vipin123", redisService.findAuthentication("efgw=hidj-klmm-nolp").getUserName());
	}
	
	@Test
	public void checkByToken() {
		assertEquals("vipin123", redisService.findAuthentication("efgw=hidj-klmm-nolp").getUserName());
	}
	

	@Test
	public void delete() {
		redisService.delete("efgw=hidj-klmm-nolp");
		assertNull(redisService.findAuthentication("efgw=hidj-klmm-nolp"));
	}
	
}
