package com.aarhankhan.userportal.controller;

import com.aarhankhan.userportal.constants.Endpoints;
import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.model.AuthModel;
import com.aarhankhan.userportal.model.UserModel;
import com.aarhankhan.userportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.BASE_URL)
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(Endpoints.AuthAPI.REGISTER_USER)
    public User registerUser(@RequestBody @Valid UserModel userModel) {
        User user = authService.createUser(userModel);
        return user;
    }

    @PostMapping(Endpoints.AuthAPI.LOGIN_USER)
    public User authorizeUser(@RequestBody @Valid AuthModel authModel) {
        User user = authService.authorizeUser(authModel);
        return user;
    }
}
