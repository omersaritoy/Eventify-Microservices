package com.example.user_service.config;

public class RestApis {
    public static final String DEVELOPER = "/dev";
    public static final String TEST = "/test";
    public static final String RELEASE = "/prod";
    public static final String VERSIONS = "/v1";

    public static final String USERSERVICE = DEVELOPER+VERSIONS+"/user";

    public static final String REGISTER = "/register";
    public static final String GETALL="/get-all";
    public static final String GETUSER="/get-user/{id}";
    public static final String UPDATE="/update/{id}";
    public static final String GETBYUSERNAME="/get-by-username/{username}";
    public static final String GETBYEMAIL="/get-by-email/{email}";
}

