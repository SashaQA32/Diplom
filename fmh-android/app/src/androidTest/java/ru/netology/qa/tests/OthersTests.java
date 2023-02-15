package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.util.Util.nestedScrollTo;
import static ru.netology.qa.util.Util.withIndex;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elemets.AuthorizationScreen;
import ru.netology.qa.elemets.ClaimsScreen;
import ru.netology.qa.steps.AboutSteps;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.MainSteps;
import ru.netology.qa.steps.NewsControlPanelSteps;
import ru.netology.qa.steps.NewsSteps;
import ru.netology.qa.steps.QuotesSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class OthersTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationScreen.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        SystemClock.sleep(1000);
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @AfterClass
    public static void Logout() {
        SystemClock.sleep(2000);
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }


// Тест-кейсы для проведения функционального тестирования вкладки "Главная" мобильного приложения "Мобильный хоспис".

    //  TC - 12 - Переход во вкладку "Все Новости" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 12")
    @Description("Переход во вкладку Все Новости через главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    public void ButtonAllNews(){

        MainSteps.clickButtonAllNews();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    //  TC - 13 - Переход во вкладку "Все Заявки" через главное меню мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 13")
    @Description("Переход во вкладку Все Заявки через главное меню мобильного приложения Мобильный хоспис (Позитивный)")
    public void ButtonAllClaims(){

        MainSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

//  Тест-кейсы для проведения функционального тестирования вкладки "Заявки" мобильного приложения "Мобильный хоспис".

    //  TC - 14 - Фильтрация заявок по критерию "Открыта" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 14")
    @Description("Фильтрация заявок по критерию Открыта во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringInProgress() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 15 - Фильтрация заявок по критерию "В работе" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 15")
    @Description("Фильтрация заявок по критерию В работе во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringOpen() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 16 - Фильтрация заявок по критерию "Выполнена" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 16")
    @Description(" Фильтрация заявок по критерию Выполнена во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void applicationFilteringExecuted() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 17 - Фильтрация заявок по критерию "Отмененные" во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 17")
    @Description("Фильтрация заявок по критерию Отмененные во вкладке Заявки мобильного приложения Мобильный хоспис(Позитивный)")
    public void applicationFilteringCancelled() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        SystemClock.sleep(2000);
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 18 - Создание заявки во вкладке "Заявки" мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("TC - 18")
    @Description("Создание заявки во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void addNewClaim() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(1000);
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 19 - Поле "Тема" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 19")
    @Description("Поле Тема пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void titleFieldIsEmpty() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.message), isFocusable()));
        ClaimsSteps.clickButtonOkError();
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
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
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldOneCharacter();
        SystemClock.sleep(1000);
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 21 - Поле "Тема" состоит из максимально-допустимого количество символов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 21")
    @Description("Поле Тема состоит из максимально-допустимого количество символов, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void titleFieldMaximumCharacters() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldMaximumCharacters();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 22 - Поле "Исполнитель" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 22")
    @Description("Поле Исполнитель пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldIsEmpty() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 23 - Ввод в поле "Исполнитель" данных, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 23")
    @Description("Ввод в поле Исполнитель данных, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void executorFieldOtherData() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldOtherData();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 24 - Поле "Исполнитель" состоит из букв и цифр, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 24")
    @Description("Поле Исполнитель состоит из букв и цифр, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void ExecutorFieldConsistsLettersAndNumbers() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldConsistsLettersAndNumbers();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 25 - Поле "Исполнитель" состоит из спецсимволов, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 25")
    @Description("Поле Исполнитель состоит из спецсимволов, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void ExecutorFieldSpecialCharacters() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsScreen.clickTitleField();
        ClaimsSteps.clickExecutorFieldSpecialCharacters();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(1000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 26 - Поле "Дата" состоит из даты будущего года, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 26")
    @Description("Поле Дата состоит из даты будущего года, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void DescriptionFieldIsEmpty() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateFieldNextYear();
        SystemClock.sleep(2000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 29 - Поле "Описание" пустое, при создании заявки, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 29")
    @Description("Поле Описание пустое, при создании заявки, во вкладке Заявки мобильного приложения Мобильный хоспис (Негативный)")
    public void DateFieldNextYear() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        SystemClock.sleep(2000);
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(allOf(withId(R.id.message), isFocusable()));
        ClaimsSteps.clickButtonOkError();
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    //  TC - 30 - Редактирование заявки, находящаяся в статусе "Открыта", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 30")
    @Description("Редактирование заявки, находящаяся в статусе Открыта, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void EditClaimStatusOpen() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(2000);
        ClaimsSteps.clickOpenClaim();
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        ClaimsSteps.clickEditClaim();
        SystemClock.sleep(1000);
        ClaimsSteps.clickEditClaimStatusOpen();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(1000);
        ViewInteraction buttonBackClaim = onView(withId(R.id.close_image_button)).perform(nestedScrollTo());
        buttonBackClaim.perform(click());
        SystemClock.sleep(1000);
        onView(withId(R.id.all_claims_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 31 - Добавление комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 31")
    @Description("Добавление комментария к заявке, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void AddComment() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickOpenClaim();
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonAddComment();
        SystemClock.sleep(2000);
        ClaimsSteps.clickCommentField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(R.id.comments_material_card_view)).check(matches(isDisplayed()));
    }

    //  TC - 32 - Редактирование комментария к заявке, во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 32")
    @Description("Редактирование комментария к заявке, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void EditComment() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickOpenClaim();
        SystemClock.sleep(1000);
        ClaimsSteps.clickButtonEditComment();
        ClaimsSteps.clickCommentField();
        ClaimsSteps.clickButtonSave();
        SystemClock.sleep(2000);
        onView(withId(R.id.comments_material_card_view)).check(matches(isDisplayed()));
    }

    //  TC - 33 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 33")
    @Description("Смена статуса заявки, находящаяся в статусе Открыта на статус В работе, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void ChangeStatusOpenForInProgress() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonFilter();
        ClaimsScreen.clickRemoveCheckBoxInProgress();
        ClaimsScreen.clickButtonOk();
        SystemClock.sleep(2000);
        ClaimsScreen.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonTakeToWork();
        SystemClock.sleep(2000);
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("In progress")))
                .check(matches(isDisplayed()));
    }

    //  TC - 34 - Смена статуса заявки, находящаяся в статусе "Открыта" на статус "В работе", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 34")
    @Description("Смена статуса заявки, находящаяся в статусе Открыта на статус В работе, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void ChangeStatusOpenForCanceled() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeDown());
        ClaimsSteps.clickOpenClaim();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        ClaimsSteps.clickButtonSettings();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonCancel();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeDown());
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("Canceled")))
                .check(matches(isDisplayed()));
    }

    //  TC - 35 - Смена статуса заявки, с истекшим сроком  исполнения, находящаяся в статусе "Открыта" на статус "В работу", во вкладке "Заявки" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 35")
    @Description("Смена статуса заявки, с истекшим сроком  исполнения, находящаяся в статусе Открыта на статус В работу, во вкладке Заявки мобильного приложения Мобильный хоспис (Позитивный)")
    public void ChangeStatusOpenForInProgressExpired() {

        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        SystemClock.sleep(2000);
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        SystemClock.sleep(2000);
        ClaimsSteps.clickButtonTakeToWork();
        SystemClock.sleep(2000);
        onView(withId(R.id.status_label_text_view))
                .check(matches(withText("In progress")))
                .check(matches(isDisplayed()));
    }

//  Тест-кейсы для проведения функционального тестирования вкладки "Новости" мобильного приложения "Мобильный хоспис".

    //  TC - 40 - Просмотр новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 40")
    @Description("Просмотр новостей во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void viewingNews() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickExpandNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    //  TC - 41 - Сортировка новостей во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 41")
    @Description("Сортировка новостей во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void newsSorting() {

        ClaimsScreen.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonSorting();
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    //  TC - 50 - Фильтрация новостей без указания категории, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 50")
    @Description("Фильтрация новостей без указания категории, во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void filteringNewsNoCategoryPositive() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 52 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 52")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени, во вкладке Новости мобильного приложения Мобильный хоспис (Позитивный)")
    public void filteringNewsCertainPeriodTime() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    //  TC - 53 - Фильтрация новостей, без указания категории, в определенный период времени, во вкладке "Новости" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 53")
    @Description("Фильтрация новостей, без указания категории, в определенный период времени, во вкладке Новости мобильного приложения Мобильный хоспис (Негативный)")
    public void filteringNewsCertainPeriodTimeNegative() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonOkWrongMessage();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(1000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

// Тест-кейсы для проведения функционального тестирования "Панели Управления Новостей" мобильного приложения "Мобильный хоспис".

    //  TC - 54 - Сортировка новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 54")
    @Description("Сортировка новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void sortingNewsControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickButtonSorting();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 55 - Просмотр новостей во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 55")
    @Description("Просмотр новостей во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void viewingNewsControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 56 - Удаление активной новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 56")
    @Description("Удаление активной новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void deletingActiveNews() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonDeleteNews();
        NewsControlPanelSteps.clickOkDeleteNews();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 57 - Редактирование новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 57")
    @Description("Редактирование новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void editNewsControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTitleNewsControlPanel();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(1000);
        NewsControlPanelSteps.clickButtonSaveEditingNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 58 - Смена статуса новости, находящаяся в статусе "АКТИВНА" на статус "НЕ АКТИВНА", во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 58")
    @Description("Смена статуса новости, находящаяся в статусе АКТИВНА на статус НЕ АКТИВНА, во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void statusChangeNews() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonSwitcher();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.content)).perform(swipeDown());
        NewsControlPanelSteps.clickButtonSaveEditingNews();
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 59 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 59")
    @Description("Фильтрация новостей по критерию Активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionActive() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 60 - Фильтрация новостей по критерию "Не активна", во вкладке "Панель управления" новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 60")
    @Description("Фильтрация новостей по критерию Не активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionNotActive() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxNotActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    //  TC - 61 - Создание новости во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 61")
    @Description("Создание новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void creationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withIndex(withId(R.id.news_item_material_card_view), 0))).check(matches(isDisplayed()));
    }

    //  TC - 62 - Поле "Категория" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 62")
    @Description("Поле Категория пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 63 - Поле "Заголовок" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 63")
    @Description("Поле Заголовок пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNew();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 64 - Поле "Дата публикации" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 64")
    @Description("Поле Дата публикации пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 65 - Поле "Время" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 65")
    @Description("Поле Время пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldTimeEmptyCreationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 66 - Поле "Описание" пустое, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 66")
    @Description("Поле Описание пустое, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldDescriptionEmptyCreationNewsInControlPanel() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    //  TC - 67 - Ввод в поле "Категория" собственного названия категории, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 67")
    @Description("Ввод в поле Категория собственного названия категории, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void customCategoryName() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsEmpty();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  TC - 68 - Поле "Категория" состоит из цифр, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 68")
    @Description("Поле Категория состоит из цифр, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryConsistsOfNumbers() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsNumbers();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  TC - 69 - Поле "Категория" состоит из спецсимволов, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 69")
    @Description("Поле Категория состоит из спецсимволов, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryConsistsOfSpecialCharacters() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingCharacters();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    //  TC - 70 - Поле "Дата публикации" состоит из даты будущего года, при создании новости, во вкладке "Панель управления" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 70")
    @Description("Поле Дата публикации состоит из даты будущего года, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void fieldDateConsistsOfNextYearCreatingNews() {

        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNextDate();
        SystemClock.sleep(2000);
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

//  Тест-кейсы для проведения функционального тестирования вкладки "Тематические цитаты" мобильного приложения "Мобильный хоспис".

    //  TC - 73 - Развернуть/свернуть тематическую цитату, во вкладке "Главное - жить любя", мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 73")
    @Description("Развернуть/свернуть тематическую цитату (Позитивный)")
    public void expandThematicQuote() {

        QuotesSteps.clickButtonThematicQuote();
        SystemClock.sleep(2000);
        QuotesSteps.clickTitleThematicQuote();
        QuotesSteps.clickButtonExpandThematicQuote();
        QuotesSteps.clickDescriptionThematicQuote();
        SystemClock.sleep(1000);
        onView(withId(R.id.our_mission_item_list_recycler_view)).check(matches(isDisplayed()));
    }

//  Тест-кейсы для проведения функционального тестирования вкладки "О приложении" мобильного приложения "Мобильный хоспис".

    //  TC - 74 - Просмотр ссылки "Политика конфиденциальности" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 74")
    @Description("Просмотр ссылки Политика конфиденциальности во вкладке О приложении (Позитивный)")
    public void transitionPrivacyPolicy() {

        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        SystemClock.sleep(2000);
        AboutSteps.clickButtonPrivacyPolicy();
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }

    //  TC - 75 - Просмотр ссылки "Пользовательское соглашение" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("TC - 75")
    @Description("Просмотр ссылки Пользовательское соглашение во вкладке О приложении (Позитивный)")
    public void transitionTermsOfUse() {

        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        SystemClock.sleep(2000);
        AboutSteps.clickButtonTermsOfUse();
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }
}
