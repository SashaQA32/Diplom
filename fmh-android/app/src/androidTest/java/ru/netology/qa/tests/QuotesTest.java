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
import ru.netology.qa.steps.QuotesSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Тематические цитаты")
public class QuotesTest {

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

    //  Тест-кейсы для проведения функционального тестирования вкладки "Тематические цитаты" мобильного приложения "Мобильный хоспис".

    //  TC - 73 - Развернуть/свернуть тематическую цитату, во вкладке "Главное - жить любя", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 73")
    @Description("Развернуть/свернуть тематическую цитату (Позитивный)")
    public void expandThematicQuote() {
        QuotesSteps.clickButtonThematicQuote();
        QuotesSteps.clickTitleThematicQuote();
        QuotesSteps.clickButtonExpandThematicQuote();
        QuotesSteps.clickDescriptionThematicQuote();
    }
}
