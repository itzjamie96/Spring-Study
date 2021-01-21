package com.blog.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.ws.UserRepository;
import com.blog.app.ws.io.entity.UserEntity;
import com.blog.app.ws.service.UserService;
import com.blog.app.ws.shared.Utils;
import com.blog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		// 이메일 중복확인
		if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
		
		UserEntity userEntity = new UserEntity();
		// BeanUtils.copyProperties(from, to) => userDto에서 받은 user정보를 userEntity에 복사해 넣겠다
		BeanUtils.copyProperties(user, userEntity);
		
		// json payload로 넘길 수 없는 값들은 직접 설정해준다
		
		// create userId for public view with length of 30 characters
		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword("testPassword");
		
	
		//repository는 이미 crud가 자동생성돼있음!!
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
				
		return returnValue;
	}

}
