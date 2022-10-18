package com.aarhankhan.userportal.service;

import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.exception.InvalidCredentialsException;
import com.aarhankhan.userportal.exception.UserNotFoundException;
import com.aarhankhan.userportal.model.ChangePasswordModel;
import com.aarhankhan.userportal.model.UserModel;
import com.aarhankhan.userportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long uid) throws UserNotFoundException {
        if(userRepository.existsById(uid)){
            return userRepository.findById(uid).orElse(null);
        }
        throw new UserNotFoundException();
    }

    @Override
    public User updateUser(Long uid, UserModel userModel) throws UserNotFoundException {
        User user = userRepository.findById(uid).orElse(null);
        if(user == null){
            throw new UserNotFoundException();
        }
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPhoneNumber(userModel.getPhoneNumber());
        userRepository.save(user);
        return user;
    }

    @Override
    public User changePassword(Long uid, ChangePasswordModel changePasswordModel) throws UserNotFoundException,InvalidCredentialsException {
        User user = userRepository.findById(uid).orElse(null);
        if(user == null){
            throw new UserNotFoundException();
        }
        if(passwordEncoder.matches(changePasswordModel.getOldPassword(),user.getPassword())){
            user.setPassword(passwordEncoder.encode(changePasswordModel.getNewPassword()));
        }
        else{
            throw new InvalidCredentialsException();
        }
        userRepository.save(user);
        return user;

    }
}
