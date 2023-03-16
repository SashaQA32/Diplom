package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.netology.qa.elements.QuotesScreen.getQuotesElementsButtonExpandThematicQuote;
import static ru.netology.qa.elements.QuotesScreen.getQuotesElementsButtonThematicQuote;
import static ru.netology.qa.elements.QuotesScreen.getQuotesElementsDescriptionThematicQuote;
import static ru.netology.qa.elements.QuotesScreen.getQuotesElementsTitleThematicQuote;
import static ru.netology.qa.elements.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class QuotesSteps {

    public static void clickButtonThematicQuote(){
        Allure.step("Нажать на кнопку Тематические цитаты");
        waitUntilElement(R.id.our_mission_image_button);
        onView(getQuotesElementsButtonThematicQuote())
                .perform(click());
    }

    public static void clickButtonExpandThematicQuote(){
        Allure.step("Развернуть тематическую цитату");
        waitUntilElement(R.id.our_mission_item_open_card_image_button);
        onView(getQuotesElementsButtonExpandThematicQuote())
                .perform(click());
    }

    public static void clickTitleThematicQuote(){
        Allure.step("Кликнуть на название тематической цитаты");
        waitUntilElement(R.id.our_mission_title_text_view);
        onView(getQuotesElementsTitleThematicQuote())
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public static void clickDescriptionThematicQuote(){
        Allure.step("Нажать на содержимое тематической цитаты");
        waitUntilElement(R.id.our_mission_item_description_text_view);
        onView(getQuotesElementsDescriptionThematicQuote())
                .check(matches(isDisplayed()));
    }
}
