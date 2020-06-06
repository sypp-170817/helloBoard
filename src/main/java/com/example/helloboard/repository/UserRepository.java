package com.example.helloboard.repository;

import com.example.helloboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByIdAndPw(String id, String pw);

}
