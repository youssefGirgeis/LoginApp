package com.youssefgirgeis.loginscreen;

/**
 * Created by youssefyacoub on 2016-10-16.
 */

public class LoginManager {

    private  String userName;
    private  String password;

    public LoginManager(String userName, String password){

        this.userName = userName;
        this.password = password;

    }

    public boolean hasValidCredentials(){

            return (userName.equals("admin") && password.equals("admin"));
    }
}
