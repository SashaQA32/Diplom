package ru.netology.qa.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.netology.qa.elemets.MainScreen.getMainElementsButtonAllNews;
import static ru.netology.qa.elemets.MainScreen.getMainElementsButtonClaims;
import static ru.netology.qa.util.Util.nestedScrollTo;

import io.qameta.allure.kotlin.Allure;

public class MainSteps {

    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews())
                .perform(click());
    }

    public static void clickButtonClaims(){
        Allure.step("Нажать на кнопку ВСЕ ЗАЯВКИ");
        onView(getMainElementsButtonClaims ())
                .perform(nestedScrollTo())
                .perform(click());
    }
}
