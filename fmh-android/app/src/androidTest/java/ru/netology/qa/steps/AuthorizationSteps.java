package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.netology.qa.elemets.AuthorizationScreen.getAuthorizationElementsButtonLogOut;
import static ru.netology.qa.elemets.AuthorizationScreen.getAuthorizationElementsLoginField;
import static ru.netology.qa.elemets.AuthorizationScreen.getAuthorizationElementsPasswordField;
import static ru.netology.qa.elemets.AuthorizationScreen.getAuthorizationElementsTextAuthorization;

import io.qameta.allure.kotlin.Allure;

public class AuthorizationSteps {

    public static void clickButton(Integer resourceId){
        Allure.step("Нажать на кнопку Войти");
        onView(withId(resourceId))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void clickLoginField(){
        Allure.step("В поле Логин ввести: login2");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordField(){
        Allure.step("В поле Пароль ввести: password2");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");
        onView(withId(resourceId))
                .perform(click());
    }

    public static void clickButtonLogOut(){
        Allure.step("Нажать на кнопку для выхода из приложения");
        onView(getAuthorizationElementsButtonLogOut())
                .perform(click());
    }

    public static void textAuthorization(){
        Allure.step("Отобразилаcь страница Авторизации");
        onView(getAuthorizationElementsTextAuthorization())
                .check(matches(isDisplayed()));
    }

    public static void clickLoginEmpty() {
        Allure.step("Поле Логин оставить пустым");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(" "), closeSoftKeyboard());
    }

    public static void clickLoginFieldUnregisteredUser() {
        Allure.step("Ввести в поле Логин данные незарегистрированного пользователя");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login123"), closeSoftKeyboard());
    }

    public static void clickLoginFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Логин спецсимволы");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("@#$^&**"), closeSoftKeyboard());
    }

    public static void clickLoginFieldOneLetter() {
        Allure.step("Ввести в поле Логин один символ");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("l"), closeSoftKeyboard());
    }

    public static void clickLoginFieldLettersOfDifferentCase() {
        Allure.step("Ввести в поле Логин буквы разного регистра");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("LoGin2"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldIsEmpty(){
        Allure.step("Поле Пароль оставить пустым");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText(" "), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldUnregisteredUser(){
        Allure.step("Ввести в поле Пароль данные незарегистрированного пользователя");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("password123"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldWithSpecialCharacters(){
        Allure.step("Ввести в поле Пароль спецсимволы");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("$%&(*^$"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldOneLetter(){
        Allure.step("Ввести в поле Пароль один символ");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("p"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldLettersOfDifferentCase(){
        Allure.step("Ввести в поле Пароль буквы разного регистра");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("PassWord2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
}
