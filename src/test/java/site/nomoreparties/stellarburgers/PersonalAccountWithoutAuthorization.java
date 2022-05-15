package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PersonalAccountWithoutAuthorization {

    @Test
    @DisplayName("Personal Account button redirects to Login Page when user is not authorized")
    public void personalAccountButtonRedirectsToLogin() {
        HeaderPage headerPage = open(ConstructorPage.URL, HeaderPage.class);

        headerPage.checkButtonHasHrefToAccount();
        headerPage.clickPersonalAccountButton();
        webdriver().shouldHave(url(LoginPage.URL));
    }

}
