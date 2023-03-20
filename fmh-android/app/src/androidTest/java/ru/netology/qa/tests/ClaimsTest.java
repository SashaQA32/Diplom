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
import ru.netology.qa.elements.ClaimsScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Заявки мобильного приложения Мобильный хоспис")
public class ClaimsTest {

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

    //  Тест-кейсы для проведения функционального тестирования вкладки "Заявки" мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Фильтрация заявок по критерию "Открыта" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).

    @Test
    @Story("TC - 14")
    @Description("Фильтрация заявок по критерию Открыта во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
    }

    //  TC - 15 - Фильтрация заявок по критерию "В работе" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Фильтрация заявок по критерию В работе во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
    }

    //  TC - 16 - Фильтрация заявок по критерию "Выполнена" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 16")
    @Description(" Фильтрация заявок по критерию Выполнена во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringExecuted() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOk();
    }

    //  TC - 17 - Фильтрация заявок по критерию "Отмененные" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 17")
    @Description("Фильтрация заявок по критерию Отмененные во вкладке Заявки мобильного приложения Мобильный хоспис(Позитивный)")
    public void applicationFilteringCancelled() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
    }

    //  TC - 18 - Создание заявки во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 18")
    @Description("Создание заявки во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void addNewClaim() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 19 - Поле "Тема" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 19")
    @Description("Поле Тема пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void titleFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    //  TC - 20 - Поле "Тема" состоит из одного символа, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 20")
    @Description("Поле Тема состоит из одного символа, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void titleFieldOneCharacter() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldOneCharacter();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 21 - Поле "Тема" состоит из максимально-допустимого количество символов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 21")
    @Description("Поле Тема состоит из максимально-допустимого количество символов, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void titleFieldMaximumCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldMaximumCharacters();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 22 - Поле "Исполнитель" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 22")
    @Description("Поле Исполнитель пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 23 - Ввод в поле "Исполнитель" данных, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 23")
    @Description("Ввод в поле Исполнитель данных, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldOtherData() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldOtherData();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 24 - Поле "Исполнитель" состоит из букв и цифр, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 24")
    @Description("Поле Исполнитель состоит из букв и цифр, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldConsistsLettersAndNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldConsistsLettersAndNumbers();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 25 - Поле "Исполнитель" состоит из спецсимволов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 25")
    @Description("Поле Исполнитель состоит из спецсимволов, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldSpecialCharacters();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 26 - Поле "Дата" состоит из даты будущего года, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 26")
    @Description("Поле Дата состоит из даты будущего года, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void descriptionFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateFieldNextYear();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 29 - Поле "Описание" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 29")
    @Description(" Поле Описание пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void dateFieldNextYear() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    //  TC - 30 - Редактирование заявки, находящаяся в статусе "Открыта", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 30")
    @Description("Редактирование заявки, находящаяся в статусе Открыта, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void editClaimStatusOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickEditClaim();
        ClaimsSteps.clickEditClaimStatusOpen();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 31 - Добавление комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 31")
    @Description("Добавление комментария к заявке, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void addComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonAddComment();
        ClaimsSteps.clickCommentField();
        ClaimsSteps.clickButtonSave();
    }

    //  TC - 32 - Редактирование комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 32")
    @Description("Редактирование комментария к заявке, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void editComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonEditComment();
        ClaimsSteps.clickCommentField();
        ClaimsScreen.clickButtonSave();
    }

    //  TC - 33 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 33")
    @Description("Смена статуса заявки, находящаяся в статусе Открыта на статус В работе, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void changeStatusOpenForInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonTakeToWork();
    }

    //  TC - 34 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 34")
    @Description("Смена статуса заявки, находящаяся в статусе Открыта на статус В работе, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void changeStatusOpenForCanceled() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonCancel();
    }

    //  TC - 35 - Смена статуса заявки, с истекшим сроком  исполнения, находящаяся в статусе "Открыта" на статус "В работу", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 35")
    @Description("Смена статуса заявки, с истекшим сроком  исполнения, находящаяся в статусе Открыта на статус В работу, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void changeStatusOpenForInProgressExpired() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonTakeToWork();
    }
}
