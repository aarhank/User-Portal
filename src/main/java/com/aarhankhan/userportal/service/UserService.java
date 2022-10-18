package com.aarhankhan.userportal.service;


import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.model.ChangePasswordModel;
import com.aarhankhan.userportal.model.UserModel;

public interface UserService {

    User getUserById(Long uid);

    User updateUser(Long uid, UserModel userModel);

    User changePassword(Long uid, ChangePasswordModel changePasswordModel);
}
