package com.blog.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.ws.service.UserService;
import com.blog.app.ws.shared.dto.UserDto;
import com.blog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.blog.app.ws.ui.model.response.UserRest;

//receive HTTP requests with url paths
@RestController		
@RequestMapping("users")	// http://localhost:8080/users/
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		
		return "getUser() was called";
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		//public하게 나타낼 수 있는 user정보를 담은 UserRest를 request에 대한 response로 리턴
		UserRest returnValue = new UserRest();
		
		// copy the data from request body(=userDetails) to userDto to access db
		UserDto userDto = new UserDto();	
		BeanUtils.copyProperties(userDetails, userDto);
		
		// service를 통해 생성된 user를 UserRest 형식으로 copy
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "updateUser() was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "deleteUser was called";
	}
}
