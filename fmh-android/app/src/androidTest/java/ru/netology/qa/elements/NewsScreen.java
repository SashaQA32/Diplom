package ru.netology.qa.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.NewsSteps;

public class NewsScreen extends NewsSteps {


    public static Matcher<View> getNewsElementsButtonNews() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

    public static Matcher<View> getNewsElementsButtonExpandNews() {
        return allOf(withIndex(withId(R.id.view_news_item_image_view), 2));
    }

    public static Matcher<View> getNewsElementsButtonSorting() {
        return allOf(withId(R.id.sort_news_material_button));
    }

    public static Matcher<View> getNewsElementsButtonFilterNews() {
        return allOf(withId(R.id.filter_news_material_button));
    }

    public static Matcher<View> getNewsElementsButtonCategoryFilter() {
        return allOf(withId(R.id.filter_button));
    }

    public static Matcher<View> getNewsElementsButtonDateStart() {
        return  allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }

    public static Matcher<View> getNewsElementsButtonOkDateStart() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsElementsButtonDateEnd() {
        return allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }

    public static Matcher<View> getNewsElementsButtonOkWrongMessage() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsElementsButtonControlPanel() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public static Matcher<View> getNewsElementsButtonClickNews() {
        return allOf(withIndex(withId(R.id.news_item_material_card_view), 0));
    }

    public static Matcher<View> getNewsElementsButtonDeleteNews() {
        return allOf(withIndex(withId(R.id.delete_news_item_image_view), 0));
    }

    public static Matcher<View> getNewsElementsTitleFilterNews() {
        return allOf(withId(R.id.filter_news_title_text_view));
    }
}
