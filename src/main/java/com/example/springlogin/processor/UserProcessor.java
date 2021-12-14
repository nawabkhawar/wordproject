package com.example.springlogin.processor;

import com.example.springlogin.WordMeaning;
import com.example.springlogin.dao.UserRepository;
import com.example.springlogin.dao.WordMeaningRepository;
import com.example.springlogin.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserProcessor {

    @Autowired
    UserRepository userRepository;

    public boolean isUserPresent(User user){
       User searchedUser = userRepository.findAll().stream().filter(user1 -> user.getEmailid().equals(user1.getEmailid())).findAny().orElse(null);
        if(null!=searchedUser){
            if(searchedUser.getPassword().equals(user.getPassword()))
                return true;
        }
        System.out.println("User not found");
        return false;

    }

}
