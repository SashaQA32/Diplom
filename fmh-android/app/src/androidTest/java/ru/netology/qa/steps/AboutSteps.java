package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.elements.AboutScreen.getAboutElementsButtonAbout;
import static ru.netology.qa.elements.AboutScreen.getAboutElementsButtonPrivacyPolicy;
import static ru.netology.qa.elements.AboutScreen.getAboutElementsButtonTermsOfUse;
import static ru.netology.qa.elements.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutSteps {

    public static void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении");
        waitUntilElement(android.R.id.title);
        onView(getAboutElementsButtonAbout())
                .perform(click());
    }

    public static void clickButtonPrivacyPolicy(){
        Allure.step("Нажать на ссылку Политика конфиденциальности");
        waitUntilElement(R.id.about_privacy_policy_value_text_view);
        onView(getAboutElementsButtonPrivacyPolicy())
                .check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }

    public static void clickButtonTermsOfUse(){
        Allure.step("Нажать на ссылку Пользовательское соглашение");
        waitUntilElement(R.id.about_terms_of_use_value_text_view);
        onView(getAboutElementsButtonTermsOfUse())
                .check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
    }
}
