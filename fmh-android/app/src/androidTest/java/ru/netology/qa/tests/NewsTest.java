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
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Новости мобильного приложения Мобильный хоспис")
public class NewsTest {

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

//  Тест-кейсы для проведения функционального тестирования вкладки "Новости" мобильного приложения "Мобильный хоспис".

    //  TC - 40 - Просмотр новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 40")
    @Description("Просмотр новостей во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void viewingNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickExpandNews();
    }

    //  TC - 41 - Сортировка новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 41")
    @Description("Сортировка новостей во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void newsSorting() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonSorting();
    }

    //  TC - 50 - Фильтрация новостей без указания категории, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 50")
    @Description("Фильтрация новостей без указания категории, во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void filteringNewsNoCategoryPositive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonCategoryFilter();
    }

    //  TC - 52 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 52")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени, во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void filteringNewsCertainPeriodTime() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
    }

    //  TC - 53 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 53")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени, во вкладке Новости мобильного приложения Мобильный хоспис (Негативный)")
    public void filteringNewsCertainPeriodTimeNegative() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonCategoryFilter();
        NewsSteps.clickButtonOkWrongMessage();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
    }
}
