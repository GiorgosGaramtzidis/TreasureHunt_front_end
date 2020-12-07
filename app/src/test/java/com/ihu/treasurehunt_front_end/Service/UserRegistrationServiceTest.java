package com.ihu.treasurehunt_front_end.Service;

import com.ihu.treasurehunt_front_end.Model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistrationServiceTest {

    private UserRegistrationService userRegistrationService;
    private UserRegistrationService userRegistrationService1;
    private UserRegistrationService userRegistrationService2;


    @Before
    public void setUp() throws Exception {
        userRegistrationService = new UserRegistrationService("GeorgeF1","123456$Ft","123456$Ft");
        userRegistrationService1 = new UserRegistrationService("Konto4","1234563@#","1234Komnto123@#");
        userRegistrationService2 = new UserRegistrationService("Konto","123","123");
    }

    @Test
    public void TestWhenPassWordAndUserNameIsValidAndPassWordsMatches() {
        assertTrue(userRegistrationService.isPasswordsMatch());
        assertTrue(userRegistrationService.passWordValidator());
        assertTrue(userRegistrationService.userNameValidator());

    }

    @Test
    public void TestWhenPasswordsDoesNotMatches() {
        assertFalse(userRegistrationService1.isPasswordsMatch());

    }

    @Test
    public void TestWhenPassWordMatchesButPassWordsDoesNotFollowRules() {
        assertTrue(userRegistrationService2.isPasswordsMatch());
        assertFalse(userRegistrationService2.passWordValidator());

    }
    @Test
    public void TestWhenUserNameDoesNotFollowTheRules()
    {
        assertFalse(userRegistrationService2.userNameValidator());
    }

    //Test Who Don't Pass

    @Test
    public void FailWhenPassWordsDoesNotMatch()
    {
        assertEquals(true,userRegistrationService1.isPasswordsMatch());
    }
    @Test
    public void FailTestWhenUseNameDoesNotFollowTheRules()
    {
        assertEquals(true,userRegistrationService2.userNameValidator());
    }
    @Test
    public void FailTestWhenPasWordDoesNotFollowTheRules()
    {
        assertEquals(true,userRegistrationService2.passWordValidator());
    }

}