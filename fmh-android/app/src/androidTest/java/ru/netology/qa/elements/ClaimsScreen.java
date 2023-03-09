package ru.netology.qa.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.qa.steps.ClaimsSteps;

public class ClaimsScreen extends ClaimsSteps {

    public static Matcher<View> getClaimsElementsButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button));
    }

    public static Matcher<View> getClaimsElementsButtonClaims () {
        return allOf(withId(android.R.id.title), withText("Claims"));
    }

    public static Matcher<View> getClaimsElementsButtonFilter () {
        return allOf(withId(R.id.filters_material_button));
    }

    public static Matcher<View> getClaimsElementsRemoveCheckBoxOpen () {
        return allOf(withId(R.id.item_filter_open));
    }

    public static Matcher<View> getClaimsElementsRemoveCheckBoxInProgress () {
        return  allOf(withId(R.id.item_filter_in_progress));
    }

    public static Matcher<View> getClaimsElementsCheckBoxExecuted () {
        return allOf(withId(R.id.item_filter_executed));
    }

    public static Matcher<View> getClaimsElementsCheckBoxCancelled() {
        return allOf(withId(R.id.item_filter_cancelled));
    }

    public static Matcher<View> getClaimsElementsButtonOk () {
        return allOf(withId(R.id.claim_list_filter_ok_material_button));
    }

    public static Matcher<View> getClaimsElementsButtonAddClaim () {
        return allOf(withId(R.id.add_new_claim_material_button));
    }

    public static Matcher<View> getClaimsElementsTitleField () {
        return allOf(withHint("Title"), withParent(withParent(withId(R.id.title_text_input_layout))));
    }

    public static Matcher<View> getClaimsElementsExecutorField () {
        return allOf(withId(R.id.executor_drop_menu_auto_complete_text_view));
    }

    public static Matcher<View> getClaimsElementsDateField () {
        return allOf(withId(R.id.date_in_plan_text_input_edit_text));
    }

    public static Matcher<View> getClaimsElementsButtonOkDate () {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getClaimsElementsTimeField () {
        return allOf(withId(R.id.time_in_plan_text_input_edit_text));
    }

    public static Matcher<View> getClaimsElementsButtonOkTime () {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getClaimsElementsDescriptionField () {
        return allOf(withId(R.id.description_edit_text));
    }

    public static Matcher<View> getClaimsElementsButtonSave () {
        return allOf(withId(R.id.save_button));
    }

    public static Matcher<View> getClaimsElementsButtonOkError () {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getClaimsElementsButtonCancelClaim () {
        return allOf(withId(R.id.cancel_button));
    }

    public static Matcher<View> getClaimsElementsButtonOkNotification () {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getClaimsElementsEditClaim () {
        return allOf(withId(R.id.edit_processing_image_button));
    }

    public static Matcher<View> getClaimsElementsOpenClaim() {
        return allOf(withIndex(withId(R.id.title_material_text_view), 0));
    }

    public static Matcher<View> getClaimsElementsButtonAddComment () {
        return allOf(withId(R.id.add_comment_image_button));
    }

    public static Matcher<View> getClaimsElementsButtonEditComment () {
        return allOf(withIndex(withId(R.id.edit_comment_image_button), 0));
    }

    public static Matcher<View> getClaimsElementsCommentField () {
        return allOf(withHint("Comment"), withParent(withParent(withId(R.id.comment_text_input_layout))));
    }

    public static Matcher<View> getClaimsElementsButtonSettings () {
        return allOf(withId(R.id.status_processing_image_button));
    }

    public static Matcher<View> getClaimsElementsButtonTakeToWork () {
        return allOf(withId(android.R.id.title), withText("take to work"));
    }

    public static Matcher<View> getClaimsElementsButtonCancel () {
        return allOf(withId(android.R.id.title), withText("Cancel"));
    }
}
