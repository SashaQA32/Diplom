package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;

import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsAddNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonCategoryCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonClickNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonControlPanel;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonDateCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonDeleteNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonEditNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonFilterNewsControlPanel;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkDateCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkDeleteNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkTimeCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonSaveCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonSaveEditingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonSorting;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonSwitcher;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonTimeCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonTitleCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsButtonTitleNewsControlPanel;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsDescriptionCreatingNews;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsFilterNewsControlPanel;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsRemoveCheckBoxActive;
import static ru.netology.qa.elements.NewsControlPanelScreen.getNewsControlPanelElementsRemoveCheckBoxNotActive;
import static ru.netology.qa.elements.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsControlPanelSteps {

    public static void clickButtonControlPanel(){
        Allure.step("Нажать на кнопку Панель управления");
        waitUntilElement(R.id.edit_news_material_button);
        onView(getNewsControlPanelElementsButtonControlPanel())
                .perform(click());
    }

    public static void clickButtonSorting(){
        Allure.step("Нажать на кнопку сортировки новостей");
        waitUntilElement(R.id.sort_news_material_button);
        onView(getNewsControlPanelElementsButtonSorting())
                .perform(click());
    }

    public static void clickButtonDeleteNews(){
        Allure.step("Нажать на кнопку Удалить новость");
        waitUntilElement(R.id.delete_news_item_image_view);
        onView(getNewsControlPanelElementsButtonDeleteNews())
                .perform(click());
    }

    public static void clickClickNews(){
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        waitUntilElement(R.id.news_item_material_card_view);
        onView(getNewsControlPanelElementsButtonClickNews())
                .perform(click());
    }

    public static void clickOkDeleteNews(){
        Allure.step("Нажать на кнопку OK Удалить новость");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelElementsButtonOkDeleteNews())
                .perform(click());
    }

    public static void clickRemoveCheckBoxNotActive(){
        Allure.step("Снять флажок с чекбокса Не активная");
        waitUntilElement(R.id.filter_news_inactive_material_check_box);
        onView(getNewsControlPanelElementsRemoveCheckBoxNotActive())
                .perform(click());
    }

    public static void clickButtonEditNews(){
        Allure.step("Нажать на кнопку Редактировать новость");
        waitUntilElement(R.id.edit_news_item_image_view);
        onView(getNewsControlPanelElementsButtonEditNews())
                .perform(click());
    }

    public static void clickButtonTitleNewsControlPanel(){
        Allure.step("Отредактировать название новости");
        waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(getNewsControlPanelElementsButtonTitleNewsControlPanel())
                .perform(clearText(), replaceText("Отредактированный текст новости"), closeSoftKeyboard());
    }

    public static void clickButtonSaveEditingNews(){
        Allure.step("Нажать на кнопку Сохранить редактирование");
        waitUntilElement(R.id.save_button);
        onView(getNewsControlPanelElementsButtonSaveEditingNews())
                .perform(click());
    }

    public static void clickButtonSwitcher(){
        Allure.step("Сменить статус");
        waitUntilElement(R.id.switcher);
        onView(getNewsControlPanelElementsButtonSwitcher())
                .perform(click());
    }

    public static void clickFilterNewsControlPanel(){
        Allure.step("Нажать на кнопку Фильтровать Новости");
        waitUntilElement(R.id.filter_news_material_button);
        onView(getNewsControlPanelElementsFilterNewsControlPanel())
                .perform(click());
    }

    public static void clickButtonFilterNewsControlPanel(){
        Allure.step("Нажать на кнопку Фильтровать");
        waitUntilElement(R.id.filter_button);
        onView(getNewsControlPanelElementsButtonFilterNewsControlPanel())
                .perform(click());
    }

    public static void clickRemoveCheckBoxActive(){
        Allure.step("Снять флажок с чекбокса Активная");
        waitUntilElement(R.id.filter_news_active_material_check_box);
        onView(getNewsControlPanelElementsRemoveCheckBoxActive())
                .perform(click());
    }

    public static void clickAddNews(){
        Allure.step("Нажать на кнопку Добавить новость");
        waitUntilElement(R.id.add_news_image_view);
        onView(getNewsControlPanelElementsAddNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews(){
        Allure.step("Выбрать категорию для создания новости");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNew(){
        Allure.step("Выбрать категорию для создания новости");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(),replaceText("День рождения"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsEmpty(){
        Allure.step("Ввести в поле Категория собственное название категории");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("Собственное название категории"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsNumbers(){
        Allure.step("Ввести в поле Категория цифры");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("123456"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingCharacters(){
        Allure.step("Ввести в поле Категория спецсимволы");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("@#$%^&**"), closeSoftKeyboard());
    }

    public static void clickButtonTitleCreatingNews(){
        Allure.step("Ввести в поле Заголовок заголовок новости");
        waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(getNewsControlPanelElementsButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText("Главные новости сегодня"), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews(){
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(click());
    }

    static String nextYear = "28.06.2024";
    public static void clickButtonDateCreatingNextDate(){
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(replaceText(nextYear));
    }

    public static void clickButtonOkDateCreatingNews(){
        Allure.step("Нажать кнопку ОК Дата");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelElementsButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews(){
        Allure.step("В поле Время выбрать время");
        waitUntilElement(R.id.news_item_publish_time_text_input_edit_text);
        onView(getNewsControlPanelElementsButtonTimeCreatingNews())
                .perform(click());
    }

    public static void clickDescriptionCreatingNews(){
        Allure.step("Ввести в поле Описание описание новости");
        waitUntilElement(R.id.news_item_description_text_input_edit_text);
        onView(getNewsControlPanelElementsDescriptionCreatingNews())
                .perform(replaceText("Новое объявление"), closeSoftKeyboard());
    }

    public static void clickButtonOkTimeCreatingNews(){
        Allure.step("Нажать кнопку ОК Время");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelElementsButtonOkTimeCreatingNews())
                .perform(click());
    }

    public static void clickButtonSaveCreatingNews(){
        Allure.step("Нажать на кнопку Сохранить новость");
        waitUntilElement(R.id.save_button);
        onView(getNewsControlPanelElementsButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }
}
