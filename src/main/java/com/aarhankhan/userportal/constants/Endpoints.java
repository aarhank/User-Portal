package com.aarhankhan.userportal.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Endpoints {
    public static final String BASE_URL = "/api/v1";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AuthAPI {


        public static final String AUTH_BASE_URL = "/auth";


        public static final String LOGIN_USER = AUTH_BASE_URL + "/login";

        public static final String REGISTER_USER = AUTH_BASE_URL + "/register";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserAPI {


        public static final String USER_BASE_URL = "/user";

        public static final String GET_USERS = USER_BASE_URL + "/all";

        public static final String UPDATE_USER = USER_BASE_URL + "/update";

        public static final String CHANGE_PASSWORD = USER_BASE_URL + "/changePassword";

    }
}
