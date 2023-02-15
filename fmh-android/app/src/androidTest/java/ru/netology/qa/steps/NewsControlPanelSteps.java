package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;

import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsAddNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonCategoryCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonClickNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonControlPanel;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonDateCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonDeleteNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonEditNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonFilterNewsControlPanel;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkDateCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkDeleteNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonOkTimeCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonSaveCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonSaveEditingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonSorting;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonSwitcher;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonTimeCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonTitleCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsButtonTitleNewsControlPanel;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsDescriptionCreatingNews;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsFilterNewsControlPanel;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsRemoveCheckBoxActive;
import static ru.netology.qa.elemets.NewsControlPanelScreen.getNewsControlPanelElementsRemoveCheckBoxNotActive;

import io.qameta.allure.kotlin.Allure;

public class NewsControlPanelSteps {

    public static void clickButtonControlPanel(){
        Allure.step("Нажать на кнопку Панель управления");
        onView(getNewsControlPanelElementsButtonControlPanel())
                .perform(click());
    }

    public static void clickButtonSorting(){
        Allure.step("Нажать на кнопку сортировки новостей");
        onView(getNewsControlPanelElementsButtonSorting())
                .perform(click());
    }

    public static void clickButtonDeleteNews(){
        Allure.step("Нажать на кнопку Удалить новость");
        onView(getNewsControlPanelElementsButtonDeleteNews())
                .perform(click());
    }

    public static void clickClickNews(){
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        onView(getNewsControlPanelElementsButtonClickNews())
                .perform(click());
    }

    public static void clickOkDeleteNews(){
        Allure.step("Нажать на кнопку OK Удалить новость");
        onView(getNewsControlPanelElementsButtonOkDeleteNews())
                .perform(click());
    }

    public static void clickRemoveCheckBoxNotActive(){
        Allure.step("Снять флажок с чекбокса Не активная");
        onView(getNewsControlPanelElementsRemoveCheckBoxNotActive())
                .perform(click());
    }

    public static void clickButtonEditNews(){
        Allure.step("Нажать на кнопку Редактировать новость");
        onView(getNewsControlPanelElementsButtonEditNews())
                .perform(click());
    }

    public static void clickButtonTitleNewsControlPanel(){
        Allure.step("Отредактировать название новости");
        onView(getNewsControlPanelElementsButtonTitleNewsControlPanel())
                .perform(clearText(), replaceText("Отредактированный текст новости"), closeSoftKeyboard());
    }

    public static void clickButtonSaveEditingNews(){
        Allure.step("Нажать на кнопку Сохранить редактирование");
        onView(getNewsControlPanelElementsButtonSaveEditingNews())
                .perform(click());
    }

    public static void clickButtonSwitcher(){
        Allure.step("Сменить статус");
        onView(getNewsControlPanelElementsButtonSwitcher())
                .perform(click());
    }

    public static void clickFilterNewsControlPanel(){
        Allure.step("Нажать на кнопку Фильтровать Новости");
        onView(getNewsControlPanelElementsFilterNewsControlPanel())
                .perform(click());
    }

    public static void clickButtonFilterNewsControlPanel(){
        Allure.step("Нажать на кнопку Фильтровать");
        onView(getNewsControlPanelElementsButtonFilterNewsControlPanel())
                .perform(click());
    }

    public static void clickRemoveCheckBoxActive(){
        Allure.step("Снять флажок с чекбокса Активная");
        onView(getNewsControlPanelElementsRemoveCheckBoxActive())
                .perform(click());
    }

    public static void clickAddNews(){
        Allure.step("Нажать на кнопку Добавить новость");
        onView(getNewsControlPanelElementsAddNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews(){
        Allure.step("Выбрать категорию для создания новости");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNew(){
        Allure.step("Выбрать категорию для создания новости");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(),replaceText("День рождения"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsEmpty(){
        Allure.step("Ввести в поле Категория собственное название категории");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("Собственное название категории"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingNewsNumbers(){
        Allure.step("Ввести в поле Категория цифры");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("123456"), closeSoftKeyboard());
    }

    public static void clickButtonCategoryCreatingCharacters(){
        Allure.step("Ввести в поле Категория спецсимволы");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click(), replaceText("@#$%^&**"), closeSoftKeyboard());
    }

    public static void clickButtonTitleCreatingNews(){
        Allure.step("Ввести в поле Заголовок заголовок новости");
        onView(getNewsControlPanelElementsButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText("Главные новости сегодня"), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews(){
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(click());
    }

    static String nextYear = "28.06.2024";
    public static void clickButtonDateCreatingNextDate(){
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(replaceText(nextYear));
    }

    public static void clickButtonOkDateCreatingNews(){
        Allure.step("Нажать кнопку ОК Дата");
        onView(getNewsControlPanelElementsButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews(){
        Allure.step("В поле Время выбрать время");
        onView(getNewsControlPanelElementsButtonTimeCreatingNews())
                .perform(click());
    }

    public static void clickDescriptionCreatingNews(){
        Allure.step("Ввести в поле Описание описание новости");
        onView(getNewsControlPanelElementsDescriptionCreatingNews())
                .perform(replaceText("Новое объявление"), closeSoftKeyboard());
    }

    public static void clickButtonOkTimeCreatingNews(){
        Allure.step("Нажать кнопку ОК Время");
        onView(getNewsControlPanelElementsButtonOkTimeCreatingNews())
                .perform(click());
    }

    public static void clickButtonSaveCreatingNews(){
        Allure.step("Нажать на кнопку Сохранить новость");
        onView(getNewsControlPanelElementsButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }
}
