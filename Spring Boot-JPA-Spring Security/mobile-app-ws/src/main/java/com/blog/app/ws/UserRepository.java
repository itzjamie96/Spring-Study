package com.blog.app.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.ws.io.entity.UserEntity;

// <Object that needs to be persisted, ID>
// repository: no need of defining basic CRUD methods
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	// custom method
	// 함수명: findBy필드명 => 알아서 또 생성해줌ㅎ
	UserEntity findByEmail(String email);
	
	
}
