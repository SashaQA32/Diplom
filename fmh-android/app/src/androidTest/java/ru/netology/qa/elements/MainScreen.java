package ru.netology.qa.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.MainSteps;

public class MainScreen extends MainSteps {

    public static Matcher<View> getMainElementsButtonAllNews() {
        return withId(R.id.all_news_text_view);
    }

    public static Matcher<View> getMainElementsButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button));
    }

    public static Matcher<View> getMainElementsButtonClaims() {
        return withId(R.id.all_claims_text_view);
    }
}
