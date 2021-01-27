package com.blog.app.ws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.app.ws.io.entity.UserEntity;
import com.blog.app.ws.io.repository.UserRepository;
import com.blog.app.ws.service.UserService;
import com.blog.app.ws.shared.Utils;
import com.blog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
		
		// 비밀번호 encryption
		// user가 타이핑한 비밀번호가 디비에 저장되기 전 encrypt될 거임
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
	
		//repository는 이미 crud가 자동생성돼있음!!
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
				
		return returnValue;
	}
	
	
	// UserDetailsService 때문에 override해야하는 코드
	// 우리는 유저네임이 사실상 이메일이니까 이메일 찾기를 한다
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if (userEntity == null) throw new UsernameNotFoundException(email);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}


	@Override
	public UserDto getUser(String email) {
		
		UserEntity userEntity = userRepository.findByEmail(email);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

}
