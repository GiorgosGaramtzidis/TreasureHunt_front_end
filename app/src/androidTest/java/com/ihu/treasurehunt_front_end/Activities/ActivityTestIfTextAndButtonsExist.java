package com.ihu.treasurehunt_front_end.Activities;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.ihu.treasurehunt_front_end.Activities.SettingsActivity.SettingsActivity;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ihu.treasurehunt_front_end.R.id.btnLogIn;
import static com.ihu.treasurehunt_front_end.R.id.txtLoginPassword;
import static com.ihu.treasurehunt_front_end.R.id.txtLoginUserName;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)

public class ActivityTestIfTextAndButtonsExist {



    @Test
    public void OnSignInActivityCheckIfAllTheFieldsAreVisible() {
        ActivityScenario.launch(SignInActivity.class);
        onView(withId(btnLogIn)).check(matches(isDisplayed()));
        onView(withId(R.id.loginText)).check(matches(isDisplayed()));
        onView(withId(R.id.txtLoginPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegisterIfNotSignedUp)).check(matches(isDisplayed()));
        onView(withId(btnLogIn)).check(matches(isDisplayed()));
        onView(withId(R.id.notSignedUpText)).check(matches(isDisplayed()));
    }

    @Test
    public void FromSignInActivityToSignUpActivityToCheckIfAllFieldsAreVisibleAndBackToSignInActivityAndCheckIfPlayButtonIsVisible() {
            ActivityScenario.launch(SignInActivity.class);
            onView(withId(R.id.btnRegisterIfNotSignedUp)).perform(click());
            onView(withId(R.id.registerText)).check(matches(isDisplayed()));
        onView(withId(R.id.txtUserName)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword2)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegistrationPattern)).check(matches(isDisplayed()));

        pressBack();
        onView(withId(btnLogIn)).check(matches(isDisplayed()));
    }

    @Test
    public void FromSignInActivityToMainActivityIfIsUserNameAndPasswordIsCorrect() {
        ActivityScenario.launch(SignInActivity.class);


        onView(withId(R.id.txtLoginUserName)).perform(typeText("Sokratis123"), closeSoftKeyboard());
        onView(withId(R.id.txtLoginPassword)).perform(typeText("Sokratis123@"), closeSoftKeyboard());
        onView(withId(btnLogIn)).perform(click());

    }

    @Test
    public void SettingsActivity () {
        ActivityScenario.launch(SettingsActivity.class);
        onView(withId(R.id.Settings)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogIn)).check(matches(isDisplayed()));
        onView(withId(R.id.btnChangePass)).check(matches(isDisplayed()));
        onView(withId(R.id.goback)).check(matches(isDisplayed()));
    }
}




