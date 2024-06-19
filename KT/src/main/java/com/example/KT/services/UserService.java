package com.example.KT.services;

import com.example.KT.model.User;
import com.example.KT.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
