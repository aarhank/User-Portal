package com.aarhankhan.userportal.service;

import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.exception.InvalidCredentialsException;
import com.aarhankhan.userportal.exception.UserAlreadyExistsException;
import com.aarhankhan.userportal.exception.UserNotFoundException;
import com.aarhankhan.userportal.model.AuthModel;
import com.aarhankhan.userportal.model.UserModel;
import com.aarhankhan.userportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserModel userModel) throws UserAlreadyExistsException {
        if(userRepository.findByEmail(userModel.getEmail())==null) {
            User user = new User();
            user.setFirstName(userModel.getFirstName());
            user.setLastName(userModel.getLastName());
            user.setEmail(userModel.getEmail());
            user.setPhoneNumber(userModel.getPhoneNumber());
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            userRepository.save(user);
            return user;
        }
        throw new UserAlreadyExistsException();

    }

    @Override
    public User authorizeUser(AuthModel authModel) throws InvalidCredentialsException, UserNotFoundException {
        User user = userRepository.findByEmail(authModel.getEmail());
        if(user !=null){
            if(passwordEncoder.matches(authModel.getPassword(),user.getPassword())){
                return user;
            }
            throw new InvalidCredentialsException();
        }
        throw new UserNotFoundException();
    }
}
