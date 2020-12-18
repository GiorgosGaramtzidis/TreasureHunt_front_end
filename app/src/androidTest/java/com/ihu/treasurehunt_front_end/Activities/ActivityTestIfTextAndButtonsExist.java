package com.ihu.treasurehunt_front_end.Activities;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.ihu.treasurehunt_front_end.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.unregisterIdlingResources;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ihu.treasurehunt_front_end.R.id.btnChangeName;
import static com.ihu.treasurehunt_front_end.R.id.on;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4ClassRunner.class)

public class ActivityTestIfTextAndButtonsExist {



    @Test
    public void OnSignInActivityCheckIfAllTheFieldsAreVisible() {
        ActivityScenario.launch(SignInActivity.class);
        onView(withId(btnChangeName)).check(matches(isDisplayed()));
        onView(withId(R.id.loginText)).check(matches(isDisplayed()));
        onView(withId(R.id.txtLoginPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegisterIfNotSignedUp)).check(matches(isDisplayed()));
        onView(withId(btnChangeName)).check(matches(isDisplayed()));
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
        onView(withId(btnChangeName)).check(matches(isDisplayed()));
    }

    @Test
    public void FromSignInActivityToMainActivityIfIsUserNameAndPasswordIsCorrect() {
        ActivityScenario.launch(SignInActivity.class);


        onView(withId(R.id.txtLoginUserName)).perform(typeText("Sokratis123"), closeSoftKeyboard());
        onView(withId(R.id.txtLoginPassword)).perform(typeText("Sokratis123@"), closeSoftKeyboard());
        onView(withId(btnChangeName)).perform(click());

    }



        /*
        onView(withId(R.id.btnSettings)).check(matches(isDisplayed()));
        onView((withId(R.id.btnSettings))).perform(click());
        ActivityScenario.launch(SettingsActivity.class);
        onView(withId(R.id.Settings)).check(matches(isDisplayed()));
        onView(withId(R.id.btnChangeName)).check(matches(isDisplayed()));
        onView(withId(R.id.btnChangePass)).check(matches(isDisplayed()));
        onView(withId(R.id.goback)).check(matches(isDisplayed()));


        onView((withId(R.id.btnChangeName))).perform(click());
        ActivityScenario.launch(NameChange.class);
        onView(withId(R.id.Settings)).check(matches(isDisplayed()));
        onView(withId(R.id.OldName)).check(matches(isDisplayed()));
        onView(withId(R.id.OldNameTEXT)).check(matches(isDisplayed()));
        onView(withId(R.id.newName)).check(matches(isDisplayed()));
        onView(withId(R.id.NewName)).check(matches(isDisplayed()));
        onView(withId(R.id.NewNameConf)).check(matches(isDisplayed()));
        onView(withId(R.id.btnChangeName)).check(matches(isDisplayed()));
        onView(withId(R.id.btnGoback)).check(matches(isDisplayed()));

*/



    }
    /*
    @Test
    public void ChangePasswordActivityCheckAllFieldsAreVisible() {

        ActivityScenario.launch(PasswordChange.class);

        onView(withId(R.id.Settings)).check(matches(isDisplayed()));
        onView(withId(R.id.OldName)).check(matches(isDisplayed()));
        //onView(withId(R.id.OldPasswordTEXT)).check(matches(isDisplayed()));
        onView(withId(R.id.newName)).check(matches(isDisplayed()));
        onView(withId(R.id.newPass)).check(matches(isDisplayed()));
        onView(withId(R.id.newPassConf)).check(matches(isDisplayed()));
        onView(withId(R.id.btnChangePass)).check(matches(isDisplayed()));
        onView(withId(R.id.btnGoback)).check(matches(isDisplayed()));
    }
*/



