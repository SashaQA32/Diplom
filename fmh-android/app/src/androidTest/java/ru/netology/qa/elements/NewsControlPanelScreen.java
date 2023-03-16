package ru.netology.qa.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qa.steps.ClaimsSteps.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.NewsControlPanelSteps;

public class NewsControlPanelScreen extends NewsControlPanelSteps {

    public static Matcher<View> getNewsControlPanelElementsButtonControlPanel() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonClickNews() {
        return allOf(withIndex(withId(R.id.news_item_material_card_view), 0));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonDeleteNews() {
        return allOf(withIndex(withId(R.id.delete_news_item_image_view), 0));
    }

    public static Matcher<View> getNewsControlPanelElementsTitleFilterNews() {
        return allOf(withId(R.id.filter_news_title_text_view));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSorting() {
        return allOf(withId(R.id.sort_news_material_button));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkDeleteNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonEditNews() {
        return  allOf(withIndex(withId(R.id.edit_news_item_image_view), 0));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonTitleNewsControlPanel() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSaveEditingNews() {
        return allOf(withId(R.id.save_button));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSwitcher() {
        return allOf(withId(R.id.switcher));
    }

    public static Matcher<View> getNewsControlPanelElementsFilterNewsControlPanel() {
        return allOf(withId(R.id.filter_news_material_button));
    }

    public static Matcher<View> getNewsControlPanelElementsRemoveCheckBoxNotActive() {
        return allOf(withId(R.id.filter_news_inactive_material_check_box));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonFilterNewsControlPanel() {
        return allOf(withId(R.id.filter_button));
    }

    public static Matcher<View> getNewsControlPanelElementsRemoveCheckBoxActive() {
        return allOf(withId(R.id.filter_news_active_material_check_box));
    }

    public static Matcher<View> getNewsControlPanelElementsAddNews() {
        return allOf(withId(R.id.add_news_image_view));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonCategoryCreatingNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonTitleCreatingNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonDateCreatingNews() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkDateCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonTimeCreatingNews() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsDescriptionCreatingNews() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonOkTimeCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelElementsButtonSaveCreatingNews() {
        return allOf(withId(R.id.save_button));
    }
}
