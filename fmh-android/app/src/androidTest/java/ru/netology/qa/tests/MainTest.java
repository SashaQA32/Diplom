package ru.netology.qa.tests;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
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
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.MainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Главная мобильного приложения Мобильный хоспис")
public class MainTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationCheck() {
        AuthorizationSteps.authorization();
    }

    @AfterClass
    public static void exit() {
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }
    // Тест-кейсы для проведения функционального тестирования вкладки "Главная" мобильного приложения "Мобильный хоспис".

    //  TC - 12 - Переход во вкладку "Все Новости" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 12")
    @Description("Переход во вкладку Все Новости через главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    public void buttonAllNews() {
        MainSteps.clickButtonAllNews();
    }

    //  TC - 13 - Переход во вкладку "Все Заявки" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Переход во вкладку \"Все Заявки\" через главное меню мобильного приложения \"Мобильный хоспис\"(Позитивный)")
    public void buttonAllClaims() {
        MainSteps.clickButtonClaims();
    }
}
