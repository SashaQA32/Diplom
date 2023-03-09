package ru.netology.qa.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elements.AuthorizationScreen;
import ru.netology.qa.steps.AboutSteps;
import ru.netology.qa.steps.AuthorizationSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Авторизация")
public class AuthorizationTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            AuthorizationScreen.textAuthorization();
        } catch (NoMatchingViewException e) {
            AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
            AuthorizationSteps.clickButtonLogOut();
        }
    }

    // Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" мобильного приложения "Мобильный хоспис".

    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 1")
    @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
    public void successfulAuthorization() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    //  TC - 2 - Поле "Логин" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 2")
    @Description("Поле Логин пустое, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void loginFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginEmpty();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 3 - Поле "Логин" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 3")
    @Description("Поле Логин заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void loginFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldUnregisteredUser();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 4 - Поле "Логин" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 4")
    @Description("Поле Логин состоит из спецсимволов, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void LoginFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 5 - Поле "Логин" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 5")
    @Description("Поле Логин состоит из одного символа, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void LoginFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldOneLetter();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 6 - Поле "Логин" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 6")
    @Description("Поле Логин состоит из букв разного регистра, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void LoginFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 7 - Поле "Пароль" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 7")
    @Description("Поле Пароль пустое, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void PasswordFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldIsEmpty();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 8 - Поле "Пароль" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 8")
    @Description("Поле Пароль заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void PasswordFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 9 - Поле "Пароль" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 9")
    @Description("Поле Пароль состоит из спецсимволов, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void PasswordFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 10 - Поле "Пароль" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 10")
    @Description("Поле Пароль состоит из одного символа, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void PasswordFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldOneLetter();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }

    //  TC - 11 - Поле "Пароль" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
    @Test
    @Story("TC - 11")
    @Description("Поле Пароль состоит из букв разного регистра, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
    public void PasswordFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AboutSteps.waitFor(3);
    }
}
