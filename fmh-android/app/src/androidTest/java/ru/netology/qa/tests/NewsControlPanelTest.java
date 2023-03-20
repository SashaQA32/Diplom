package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.pressBack;

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
import ru.netology.qa.elements.NewsControlPanelScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.NewsControlPanelSteps;
import ru.netology.qa.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования Панели Управления Новостей мобильного приложения Мобильный хоспис")

public class NewsControlPanelTest {

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

// Тест-кейсы для проведения функционального тестирования "Панели Управления Новостей" мобильного приложения "Мобильный хоспис".

    //  TC - 54 - Сортировка новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 54")
    @Description("Сортировка новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void sortingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelScreen.clickButtonControlPanel();
        NewsControlPanelScreen.clickButtonSorting();
    }

    //  TC - 55 - Просмотр новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 55")
    @Description("Просмотр новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void viewingNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
    }

    //  TC - 56 - Удаление активной новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 56")
    @Description("Удаление активной новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void deletingActiveNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonDeleteNews();
        NewsControlPanelSteps.clickOkDeleteNews();
    }

    //  TC - 57 - Редактирование новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 57")
    @Description("Редактирование новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void editNewsControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonTitleNewsControlPanel();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    //  TC - 58 - Смена статуса новости, находящаяся в статусе "АКТИВНА" на статус "НЕ АКТИВНА", во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 58")
    @Description("Смена статуса новости, находящаяся в статусе АКТИВНА на статус НЕ АКТИВНА, во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void statusChangeNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonSwitcher();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    //  TC - 59 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 59")
    @Description("Фильтрация новостей по критерию Активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

    //  TC - 60 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 60")
    @Description("Фильтрация новостей по критерию Не активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionNotActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxNotActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

    //  TC - 61 - Создание новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 61")
    @Description("Создание новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void creationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
    }

    //  TC - 62 - Поле "Категория" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 62")
    @Description("Поле Категория пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 63 - Поле "Заголовок" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 63")
    @Description("Поле Заголовок пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNew();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 64 - Поле "Дата публикации" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 64")
    @Description("Поле Дата публикации пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 65 - Поле "Время" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 65")
    @Description("Поле Время пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")

    public void fieldTimeEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 66 - Поле "Описание" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 66")
    @Description("Поле Описание пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 67 - Ввод в поле "Категория" собственного названия категории, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 67")
    @Description("Ввод в поле Категория собственного названия категории, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void customCategoryName() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsEmpty();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    //  TC - 68 - Поле "Категория" состоит из цифр, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 68")
    @Description("Поле Категория состоит из цифр, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryConsistsOfNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsNumbers();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    //  TC - 69 - Поле "Категория" состоит из спецсимволов, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 69")
    @Description("Поле Категория состоит из спецсимволов, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingCharacters();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    //  TC - 70 - Поле "Дата публикации" состоит из даты будущего года, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 70")
    @Description("Поле Дата публикации состоит из даты будущего года, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void fieldDateConsistsOfNextYearCreatingNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
    }
}
