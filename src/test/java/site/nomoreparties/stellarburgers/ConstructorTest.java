package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    @Test
    @DisplayName("List scrolls to Buns section when click on Buns")
    public void checkBunsAnchorOpensBunsSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.clickBuns();
        constructorPage.checkBunsHeaderIsVisible();
    }

    @Test
    @DisplayName("List scrolls to Sauces section when click on Sauces")
    public void checkSaucesAnchorOpensSaucesSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.clickSauces();
        constructorPage.checkSaucesHeaderIsVisible();
    }

    @Test
    @DisplayName("List scrolls to Fillings section when click on Fillings")
    public void checkFillingsAnchorOpensFillingsSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.clickFillings();
        constructorPage.checkFillingsHeaderIsVisible();
    }
}
