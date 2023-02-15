package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonCategoryFilter;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonDateEnd;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonDateStart;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonExpandNews;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonFilterNews;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonNews;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonOkDateStart;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonOkWrongMessage;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsButtonSorting;
import static ru.netology.qa.elemets.NewsScreen.getNewsElementsTitleFilterNews;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;

public class NewsSteps {


    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        onView(getNewsElementsButtonNews())
                .perform(click());
    }

    public static void clickExpandNews() {
        Allure.step("Нажать на кнопку развернуть новость");
        onView(getNewsElementsButtonExpandNews())
                .perform(doubleClick());
    }

    public static void clickButtonSorting() {
        Allure.step("Нажать на кнопку сортировки новостей");
        onView(getNewsElementsButtonSorting())
                .perform(click());
    }

    public static void clickButtonFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать Новости");
        onView(getNewsElementsButtonFilterNews())
                .perform(click());
    }

    public static void clickButtonCategoryFilter() {
        Allure.step("Выбрать категорию для фильтрации новостей");
        onView(getNewsElementsButtonCategoryFilter())
                .perform(click());
    }

    public static void clickButtonDateStart() {
        Allure.step("Указать диапазон дат - начальная дата");
        onView(getNewsElementsButtonDateStart())
                .perform(click());
    }

    public static void clickButtonOkDateStart() {
        Allure.step("Нажать на кнопку ОК");
        onView(getNewsElementsButtonOkDateStart())
                .perform(click());
    }

    static String date = "15.02.2023";

    public static void clickButtonDateEnd() {
        Allure.step("Указать диапазон дат - конечная дата");
        onView(getNewsElementsButtonDateEnd())
                .perform(replaceText(date));
    }

    public static void clickButtonOkWrongMessage() {
        Allure.step("Нажать на кнопку ОК в Уведомлении");
        onView(getNewsElementsButtonOkWrongMessage())
                .perform(click());
    }

    public static void clickButtonTitleFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать Новости");
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
