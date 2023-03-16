package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonAddClaim;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonAddComment;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonCancel;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonCancelClaim;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonClaims;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonEditComment;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonFilter;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonMainMenu;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonOk;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonOkDate;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonOkError;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonOkNotification;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonOkTime;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonSave;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonSettings;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsButtonTakeToWork;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsCheckBoxCancelled;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsCheckBoxExecuted;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsCommentField;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsDateField;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsDescriptionField;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsEditClaim;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsExecutorField;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsOpenClaim;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsRemoveCheckBoxInProgress;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsRemoveCheckBoxOpen;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsTimeField;
import static ru.netology.qa.elements.ClaimsScreen.getClaimsElementsTitleField;
import static ru.netology.qa.elements.WaitId.waitFor;
import static ru.netology.qa.elements.WaitId.waitUntilElement;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ClaimsSteps {


    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitUntilElement(R.id.main_menu_image_button);
        waitFor(2);
        onView(getClaimsElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonClaims() {
        Allure.step("Нажать на кнопку Заявки");
        waitUntilElement(android.R.id.title);
        onView(getClaimsElementsButtonClaims())
                .perform(click());
    }

    public static void clickButtonFilter() {
        Allure.step("Нажать на кнопку Фильтрация");
        waitUntilElement(R.id.filters_material_button);
        onView(getClaimsElementsButtonFilter())
                .perform(click());
    }

    public static void clickRemoveCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Открыта");
        waitUntilElement(R.id.item_filter_open);
        onView(getClaimsElementsRemoveCheckBoxOpen())
                .perform(click());
    }

    public static void clickButtonOk() {
        Allure.step("Нажать кнопку ОК");
        waitUntilElement(R.id.claim_list_filter_ok_material_button);
        onView(getClaimsElementsButtonOk())
                .perform(click());
    }

    public static void clickRemoveCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса В работе");
        waitUntilElement(R.id.item_filter_in_progress);
        onView(getClaimsElementsRemoveCheckBoxInProgress())
                .perform(click());
    }

    public static void clickCheckBoxExecuted() {
        Allure.step("Выбрать критерий для фильтрации Выполнена");
        waitUntilElement(R.id.item_filter_executed);
        onView(getClaimsElementsCheckBoxExecuted())
                .perform(click());
    }

    public static void clickCheckBoxCancelled() {
        Allure.step("Выбрать критерий для фильтрации Отмененные");
        waitUntilElement(R.id.item_filter_cancelled);
        onView(getClaimsElementsCheckBoxCancelled())
                .perform(click());
    }

    public static void clickButtonAddClaim() {
        Allure.step("Нажать на кнопку Создание Заявки");
        waitUntilElement(R.id.add_new_claim_material_button);
        onView(getClaimsElementsButtonAddClaim())
                .perform(click());
    }

    public static void clickTitleField() {
        Allure.step("Ввести в поле Тема наименование темы");
        waitUntilElement(R.id.title_text_input_layout);
        onView(getClaimsElementsTitleField())
                .perform(replaceText("Осмотр"), closeSoftKeyboard());
    }

    public static void clickCheckBoxExecutorField() {
        Allure.step("В поле Исполнитель выбрать из списка ФИО исполнителя");
        waitUntilElement(R.id.executor_drop_menu_auto_complete_text_view);
        onView(getClaimsElementsExecutorField())
                .perform(replaceText("Смирнов Николай Петрович"), closeSoftKeyboard());
    }

    public static void clickDateField() {
        Allure.step("Нажать на поле Дата");
        waitUntilElement(R.id.date_in_plan_text_input_edit_text);
        onView(getClaimsElementsDateField())
                .perform(click());
    }

    public static void clickButtonOkDate() {
        Allure.step("Нажать кнопку ОК");
        waitUntilElement(android.R.id.button1);
        onView(getClaimsElementsButtonOkDate())
                .perform(click());
    }

    public static void clickTimeField() {
        Allure.step("Нажать на поле Время");
        waitUntilElement(R.id.time_in_plan_text_input_edit_text);
        onView(getClaimsElementsTimeField())
                .perform(click());
    }

    public static void clickButtonOkTime() {
        Allure.step("Нажать кнопку ОК");
        waitUntilElement(android.R.id.button1);
        onView(getClaimsElementsButtonOkTime())
                .perform(click());
    }

    public static void clickDescriptionField() {
        Allure.step("Ввести в поле Описание описание заявки");
        waitUntilElement(R.id.description_edit_text);
        onView(getClaimsElementsDescriptionField())
                .perform(replaceText("Срочный осмотр"), closeSoftKeyboard());
    }

    public static void clickButtonSave() {
        Allure.step("Нажать на кнопку Сохранить");
        waitUntilElement(R.id.save_button);
        onView(getClaimsElementsButtonSave())
                .perform(click());
    }

    public static void clickButtonOkError() {
        Allure.step("Нажать кнопку ОК");
        waitUntilElement(android.R.id.button1);
        onView(getClaimsElementsButtonOkError())
                .perform(click());
    }

    public static void clickButtonCancelClaim() {
        Allure.step("Нажать кнопку Отмена");
        waitUntilElement(R.id.cancel_button);
        onView(getClaimsElementsButtonCancelClaim())
                .perform(click());
    }

    public static void clickButtonOkNotification() {
        Allure.step("Нажать кнопку ОК Уведомления");
        waitUntilElement(android.R.id.button1);
        onView(getClaimsElementsButtonOkNotification())
                .perform(click());
    }

    public static void clickTitleFieldOneCharacter() {
        Allure.step("Ввести в поле Тема один символ");
        onView(getClaimsElementsTitleField())
                .perform(replaceText("1"), closeSoftKeyboard());
    }

    public static void clickTitleFieldMaximumCharacters() {
        Allure.step("Ввести в поле Тема максимально-допустимое количество символов");
        onView(getClaimsElementsTitleField())
                .perform(replaceText("123456789АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ1234567891011"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldConsistsLettersAndNumbers() {
        Allure.step("Ввести в поле Исполнитель буквы латинского алфавита и цифры");
        onView(getClaimsElementsExecutorField())
                .perform(replaceText("И123ванов И456ванович И789ванов"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldOtherData() {
        Allure.step("Ввести в поле Исполнитель другие данные");
        onView(getClaimsElementsExecutorField())
                .perform(replaceText("Иванов Иванович Иванов"), closeSoftKeyboard());
    }

    public static void clickExecutorFieldSpecialCharacters() {
        Allure.step("Ввести в поле Исполнитель спецсимволы");
        onView(getClaimsElementsExecutorField())
                .perform(replaceText("@#$$%%^&**"), closeSoftKeyboard());
    }

    static String nextYear = "28.06.2024";

    public static void clickDateFieldNextYear() {
        Allure.step("В поле Дата выбрать дату будущего года");
        onView(getClaimsElementsDateField())
                .perform(replaceText(nextYear));
    }

    public static void clickOpenClaim() {
        Allure.step("Открыть Заявку");
        waitUntilElement(R.id.title_material_text_view);
        onView(getClaimsElementsOpenClaim())
                .perform(click());
    }

    public static void clickEditClaim() {
        Allure.step("Нажать на кнопку Редактирование Заявки");
        waitUntilElement(R.id.edit_processing_image_button);
        onView(getClaimsElementsEditClaim())
                .perform(click());
    }

    public static void clickEditClaimStatusOpen() {
        Allure.step("Нажать на заявку, находящаяся в статусе Открыта, для редактирования");
        onView(getClaimsElementsDescriptionField())
                .perform(clearText(), replaceText("Редактирование заявки, находящаяся в статусе Открыта"),
                        closeSoftKeyboard());
    }

    public static void clickButtonAddComment() {
        Allure.step("Нажать на кнопку Добавить комментарий");
        waitUntilElement(R.id.add_comment_image_button);
        onView(getClaimsElementsButtonAddComment())
                .perform(click());
    }

    public static void clickCommentField() {
        Allure.step("В поле Комментарий добавить комментарий");
        waitUntilElement(R.id.comment_text_input_layout);
        onView(getClaimsElementsCommentField())
                .perform(clearText(), replaceText("Новый комментарий"), closeSoftKeyboard());
    }

    public static void clickButtonEditComment() {
        Allure.step("Нажать на кнопку Редактировать комментарий");
        waitUntilElement(R.id.edit_comment_image_button);
        onView(getClaimsElementsButtonEditComment())
                .perform(click());
    }

    public static void clickButtonSettings() {
        Allure.step("Нажать на кнопку Настройки");
        waitUntilElement(R.id.status_processing_image_button);
        onView(getClaimsElementsButtonSettings())
                .perform(click());
    }

    public static void clickButtonTakeToWork() {
        Allure.step("Сменить статус заявки, находящаяся в статусе Открыта на статус В работе");
        waitUntilElement(android.R.id.title);
        onView(getClaimsElementsButtonTakeToWork())
                .perform(click());
    }

    public static void clickButtonCancel() {
        Allure.step("Нажать на кнопку Отмена");
        waitUntilElement(android.R.id.title);
        onView(getClaimsElementsButtonCancel())
                .perform(click());
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                return false;
            }

            int currentIndex = 0;
        };
    }
}

