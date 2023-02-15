package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.elemets.AboutScreen.getAboutElementsButtonAbout;
import static ru.netology.qa.elemets.AboutScreen.getAboutElementsButtonPrivacyPolicy;
import static ru.netology.qa.elemets.AboutScreen.getAboutElementsButtonTermsOfUse;

import io.qameta.allure.kotlin.Allure;

public class AboutSteps {

    public static void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении");
        onView(getAboutElementsButtonAbout())
                .perform(click());
    }

    public static void clickButtonPrivacyPolicy(){
        Allure.step("Нажать на ссылку Политика конфиденциальности");
        onView(getAboutElementsButtonPrivacyPolicy())
                .check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }

    public static void clickButtonTermsOfUse(){
        Allure.step("Нажать на ссылку Пользовательское соглашение");
        onView(getAboutElementsButtonTermsOfUse())
                .check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
    }
}
