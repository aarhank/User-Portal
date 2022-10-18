package com.aarhankhan.userportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordModel {
    @NotBlank(message = "Old password can not be empty")
    private String oldPassword;
    @NotBlank(message = "New password can not be empty")
    private String newPassword;
}
