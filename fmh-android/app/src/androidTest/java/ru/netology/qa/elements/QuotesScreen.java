package ru.netology.qa.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.steps.ClaimsSteps.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class QuotesScreen {

    public static Matcher<View> getQuotesElementsButtonThematicQuote() {
        return allOf(withId(R.id.our_mission_image_button));
    }

    public static Matcher<View> getQuotesElementsButtonExpandThematicQuote() {
        return allOf(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    }

    public static Matcher<View> getQuotesElementsTitleThematicQuote() {
        return allOf(withId(R.id.our_mission_title_text_view));
    }

    public static Matcher<View> getQuotesElementsDescriptionThematicQuote() {
        return allOf(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
    }
}
