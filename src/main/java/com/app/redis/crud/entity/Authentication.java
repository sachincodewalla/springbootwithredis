package com.app.redis.crud.entity;

import java.io.Serializable;

public class Authentication implements Serializable {

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	private static final long serialVersionUID = 1L;

	private String token;
	
	private String userName;
	
	private Long userId;
	
	private Integer organizationId;
}
