package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonCategoryFilter;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonDateEnd;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonDateStart;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonExpandNews;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonFilterNews;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonNews;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonOkDateStart;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonOkWrongMessage;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsButtonSorting;
import static ru.netology.qa.elements.NewsScreen.getNewsElementsTitleFilterNews;
import static ru.netology.qa.elements.WaitId.waitUntilElement;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsSteps {


    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        waitUntilElement(android.R.id.title);
        onView(getNewsElementsButtonNews())
                .perform(click());
    }

    public static void clickExpandNews() {
        Allure.step("Нажать на кнопку развернуть новость");
        waitUntilElement(R.id.view_news_item_image_view);
        onView(getNewsElementsButtonExpandNews())
                .perform(doubleClick());
    }

    public static void clickButtonSorting() {
        Allure.step("Нажать на кнопку сортировки новостей");
        waitUntilElement(R.id.sort_news_material_button);
        onView(getNewsElementsButtonSorting())
                .perform(click());
    }

    public static void clickButtonFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать Новости");
        waitUntilElement(R.id.filter_news_material_button);
        onView(getNewsElementsButtonFilterNews())
                .perform(click());
    }

    public static void clickButtonCategoryFilter() {
        Allure.step("Выбрать категорию для фильтрации новостей");
        waitUntilElement(R.id.filter_button);
        onView(getNewsElementsButtonCategoryFilter())
                .perform(click());
    }

    public static void clickButtonDateStart() {
        Allure.step("Указать диапазон дат - начальная дата");
        waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        onView(getNewsElementsButtonDateStart())
                .perform(click());
    }

    public static void clickButtonOkDateStart() {
        Allure.step("Нажать на кнопку ОК");
        waitUntilElement(android.R.id.button1);
        onView(getNewsElementsButtonOkDateStart())
                .perform(click());
    }

    static String date = "20.03.2023";

    public static void clickButtonDateEnd() {
        Allure.step("Указать диапазон дат - конечная дата");
        waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        onView(getNewsElementsButtonDateEnd())
                .perform(replaceText(date));
    }

    public static void clickButtonOkWrongMessage() {
        Allure.step("Нажать на кнопку ОК в Уведомлении");
        waitUntilElement(android.R.id.button1);
        onView(getNewsElementsButtonOkWrongMessage())
                .perform(click());
    }

    public static void clickButtonTitleFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать Новости");
        waitUntilElement(R.id.filter_news_title_text_view);
        onView(getNewsElementsTitleFilterNews())
                .check(matches(allOf(withText("Filter news"), isDisplayed())))
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
