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
        String passwordPattern = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        return password.matches(passwordPattern);
    }
    public Boolean userNameValidator()
    {
        String userPattern = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
        return userName.matches(userPattern);
    }
}
