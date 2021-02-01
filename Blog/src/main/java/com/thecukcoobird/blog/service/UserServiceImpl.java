package com.thecukcoobird.blog.service;

import com.thecukcoobird.blog.model.User;
import com.thecukcoobird.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
