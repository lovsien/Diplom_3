package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.ConstructorPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    @Test
    @DisplayName("List scrolls to Buns section when clicking on Buns")
    public void checkBunsAnchorOpensBunsSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.checkScrollToBunsIsWorking();
    }

    @Test
    @DisplayName("List scrolls to Sauces section when clicking on Sauces")
    public void checkSaucesAnchorOpensSaucesSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.clickSauces();
        constructorPage.checkScrollToSaucesIsWorking();
    }

    @Test
    @DisplayName("List scrolls to Fillings section when clicking on Fillings")
    public void checkFillingsAnchorOpensFillingsSection() {
        ConstructorPage constructorPage = open(ConstructorPage.URL, ConstructorPage.class);

        constructorPage.clickFillings();
        constructorPage.checkScrollToFillingsIsWorking();
    }
}
