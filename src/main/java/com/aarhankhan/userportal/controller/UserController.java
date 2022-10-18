package com.aarhankhan.userportal.controller;

import com.aarhankhan.userportal.constants.Endpoints;
import com.aarhankhan.userportal.entity.User;
import com.aarhankhan.userportal.model.ChangePasswordModel;
import com.aarhankhan.userportal.model.UserModel;
import com.aarhankhan.userportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoints.BASE_URL)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(Endpoints.UserAPI.USER_BASE_URL)
    public User getUserDetails(@RequestParam Long uid) {
        return userService.getUserById(uid);
    }

    @PutMapping(Endpoints.UserAPI.UPDATE_USER)
    public User updateUser(@RequestParam Long uid, @RequestBody UserModel userModel){
        return userService.updateUser(uid, userModel);
    }

    @PutMapping(Endpoints.UserAPI.CHANGE_PASSWORD)
    public User changePassword(@RequestParam Long uid, @RequestBody ChangePasswordModel changePasswordModel){
        return userService.changePassword(uid, changePasswordModel);
    }



}
