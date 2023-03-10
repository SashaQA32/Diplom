package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elements.AuthorizationScreen;
import ru.netology.qa.steps.AboutSteps;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки О приложении")
public class AboutTest {

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
            return;
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        AboutSteps.waitFor(2);
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @AfterClass
    public static void Exit() {
        AboutSteps.waitFor(2);
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AboutSteps.waitFor(2);
        AuthorizationSteps.clickButtonLogOut();
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "О приложении" мобильного приложения "Мобильный хоспис".

    //  TC - 74 - Просмотр ссылки "Политика конфиденциальности" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 74")
    @Description("Просмотр ссылки Политика конфиденциальности во вкладке О приложении (Позитивный)")
    public void transitionPrivacyPolicy() {
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.waitFor(2);
        AboutSteps.clickButtonPrivacyPolicy();
        AboutSteps.waitFor(3);
        //Выход
        pressBack();
    }

    //  TC - 75 - Просмотр ссылки "Пользовательское соглашение" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 75")
    @Description("Просмотр ссылки Пользовательское соглашение во вкладке О приложении (Позитивный)")
    public void transitionTermsOfUse() {
        AboutSteps.waitFor(2);
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.waitFor(2);
        AboutSteps.clickButtonTermsOfUse();
        AboutSteps.waitFor(3);
        //Выход
        pressBack();
    }
}
