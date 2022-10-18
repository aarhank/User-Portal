package com.aarhankhan.userportal.service;

import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.model.AuthModel;
import com.aarhankhan.userportal.model.UserModel;

public interface AuthService {
    User createUser(UserModel userModel);

    User authorizeUser(AuthModel authModel);
}
