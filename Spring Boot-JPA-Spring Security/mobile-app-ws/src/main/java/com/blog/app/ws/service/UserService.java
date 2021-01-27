package com.blog.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.blog.app.ws.shared.dto.UserDto;

//UserDetailsService : Spring security에서 제공하는 유저 관련 서비스 패키지
public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto user);
	
	UserDto getUser(String email);
	
}
