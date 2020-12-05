package com.ihu.treasurehunt_front_end.Service;

public class UserRegistrationService
{
    private final String userName;
    private final String password;
    private final String secondPassword;

    public UserRegistrationService(String userName, String password, String secondPassword) {
        this.userName = userName;
        this.password = password;
        this.secondPassword = secondPassword;
    }

    public Boolean isPasswordsMatch()
    {
        return password.equals(secondPassword);
    }

    public Boolean passWordValidator()
    {
        String pattern = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(pattern);
    }
    public Boolean userNameValidator()
    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$";
        return userName.matches(pattern);
    }
}
