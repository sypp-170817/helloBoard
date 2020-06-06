package com.example.helloboard.service;

import com.example.helloboard.entity.UserEntity;
import com.example.helloboard.param.request.UserReq;
import com.example.helloboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void join(UserReq userReq) {
        UserEntity userEntity = UserEntity.builder()
                .id(userReq.getId()).pw(userReq.getPw()).build();
        userRepository.save(userEntity);
    }

    public void login(UserReq userReq) throws IllegalAccessException {
        UserEntity userEntity = userRepository.findByIdAndPw(userReq.getId(),userReq.getPw());
        if(userEntity == null) throw new IllegalAccessException("계정읎음");
    }


}
